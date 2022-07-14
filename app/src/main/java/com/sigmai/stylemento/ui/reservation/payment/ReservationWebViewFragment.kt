package com.sigmai.stylemento.ui.reservation.payment

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.load.engine.Resource
import com.google.android.gms.common.util.IOUtils
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationPaymentBinding
import com.sigmai.stylemento.databinding.FragmentReservationWebViewBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.TimeUtil
import com.sigmai.stylemento.ui.reservation.adapter.TimeAdapter
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.io.File
import java.net.URISyntaxException
import java.nio.file.Paths

@AndroidEntryPoint
class ReservationWebViewFragment : BaseFragment<FragmentReservationWebViewBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_web_view
    private val viewModel: ReservationViewModel by viewModels({ requireParentFragment() })

    private var cardHtml = "<html><head><script src='https://js.tosspayments.com/v1'></script></head><body><script> var clientKey = 'test_ck_jkYG57Eba3G06EgN4PwVpWDOxmA1'\n var tossPayments = TossPayments(clientKey)\n var button = document.getElementById('payment-button')\ntossPayments.requestPayment('카드', { amount: _amount,orderId: '_orderId',orderName: '_orderName',customerName: '_customerName',successUrl: 'http://13.125.39.167:9090/v1/api/payment/success',failUrl: 'http://13.125.39.167:9090/v1/api/payment/fail', })</script></body></html>"
    private var virtualHtml = "<html><head><script src='https://js.tosspayments.com/v1'></script></head><body><script> var clientKey = 'test_ck_jkYG57Eba3G06EgN4PwVpWDOxmA1'\n var tossPayments = TossPayments(clientKey)\n var button = document.getElementById('payment-virtual-account-button')\ntossPayments.requestPayment('가상계좌', { amount: _amount,orderId: '_orderId',orderName: '_orderName',customerName: '_customerName',successUrl: 'http://13.125.39.167:9090/v1/api/payment/success',failUrl: 'http://13.125.39.167:9090/v1/api/payment/fail',validHours: 6,cashReceipt: { type: '소득공제', },useEscrow: false, })</script></body></html>"

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigateUp()
        }
        viewModel.startNext.observe(this) {
            findNavController().navigate(R.id.action_reservation_web_view_page_to_reservation_payment_complete_page)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.paymentWebView.settings.javaScriptEnabled = true
        binding.paymentWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean =
                url.let()
                {
                    Timber.d("------------------------------------------------------------------------------")
                    Timber.d(url)
                    if (!URLUtil.isNetworkUrl(url) && !URLUtil.isJavaScriptUrl(url)) {
                        val uri = try {
                            Uri.parse(url)
                        } catch (e: Exception) {
                            return false
                        }

                        return when (uri.scheme) {
                            "intent" -> {
                                startSchemeIntent(it)
                            }
                            else -> {
                                return try {
                                    startActivity(Intent(Intent.ACTION_VIEW, uri))
                                    true
                                } catch (e: java.lang.Exception) {
                                    false
                                }
                            }
                        }
                    } else {
                        return false
                    }
                }

            private fun startSchemeIntent(url: String): Boolean {
                val schemeIntent: Intent = try {
                    Intent.parseUri(url, Intent.URI_INTENT_SCHEME)
                } catch (e: URISyntaxException) {
                    return false
                }
                try {
                    startActivity(schemeIntent)
                    return true
                } catch (e: ActivityNotFoundException) {
                    val packageName = schemeIntent.getPackage()

                    if (!packageName.isNullOrBlank()) {
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=$packageName")
                            )
                        )
                        return true
                    }
                }
                return false
            }
        }
        binding.paymentWebView.webChromeClient = WebChromeClient()

        if(viewModel.payType.value == 0){
            cardHtml = cardHtml.replace("_amount", viewModel.paymentInfo.value!!.amount.toString())
            cardHtml = cardHtml.replace("_orderId", viewModel.paymentInfo.value!!.orderId)
            cardHtml = cardHtml.replace("_orderName", viewModel.paymentInfo.value!!.orderName)
            cardHtml = cardHtml.replace("_customerName", viewModel.paymentInfo.value!!.customerName)
            binding.paymentWebView.loadData(cardHtml, "text/html", "UTF-8")
        }
        else {
            virtualHtml = virtualHtml.replace("_amount", viewModel.paymentInfo.value!!.amount.toString())
            virtualHtml = virtualHtml.replace("_orderId", viewModel.paymentInfo.value!!.orderId)
            virtualHtml = virtualHtml.replace("_orderName", viewModel.paymentInfo.value!!.orderName)
            virtualHtml = virtualHtml.replace("_customerName", viewModel.paymentInfo.value!!.customerName)
            binding.paymentWebView.loadData(virtualHtml, "text/html", "UTF-8")
        }

    }

}