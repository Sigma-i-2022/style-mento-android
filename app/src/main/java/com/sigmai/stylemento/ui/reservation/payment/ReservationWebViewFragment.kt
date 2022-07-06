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
import java.io.File
import java.net.URISyntaxException
import java.nio.file.Paths

@AndroidEntryPoint
class ReservationWebViewFragment : BaseFragment<FragmentReservationWebViewBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_web_view
    private val viewModel: ReservationViewModel by viewModels({ requireParentFragment() })

    var content = "<html><head><script src='https://js.tosspayments.com/v1'></script></head><body><section><span>총 주문금액</span><span>_amount 원</span><button id='payment-button'>_amount원 결제하기</button></section><section><span>총 주문금액</span><span>_amount 원</span><button id='payment-virtual-account-button'>_amount원 결제하기</button></section><script> var clientKey = 'test_ck_D5GePWvyJnrK0W0k6q8gLzN97Eoq'\n var tossPayments = TossPayments(clientKey)\n var button = document.getElementById('payment-button')\nbutton.addEventListener('click', function () { tossPayments.requestPayment('카드', { amount: _amount, orderId: '_orderId', orderName: '_orderName', customerName: '_customerName', successUrl: 'http://localhost:9090/v1/api/payment/success', failUrl: 'http://localhost:9090/v1/api/payment/fail', }) })</script><script> var clientKey = 'test_ck_D5GePWvyJnrK0W0k6q8gLzN97Eoq'\n var tossPayments = TossPayments(clientKey)\n var button = document.getElementById('payment-virtual-account-button')\nbutton.addEventListener('click', function () { tossPayments.requestPayment('가상계좌', { amount: _amount,orderId: '_orderId',orderName: '_orderName',customerName: '_customerName',successUrl: 'http://localhost:9090/v1/api/payment/success',failUrl: 'http://localhost:9090/v1/api/payment/fail',validHours: 6,cashReceipt: { type: '소득공제', },useEscrow: false, }) })</script></body></html>"


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
//        binding.paymentWebView.loadUrl("file:///android_asset/payment_page.html")
        binding.paymentWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean =
                url.let()
                {
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

//        val arg = viewModel.paymentInfo.value!!.amount.toString() + ", " +
//                viewModel.paymentInfo.value!!.orderId + ", " +
//                viewModel.paymentInfo.value!!.orderName + ", " +
//                viewModel.paymentInfo.value!!.customerName + ", " +
//                viewModel.paymentInfo.value!!.customerEmail
//
        content = content.replace("_amount", viewModel.paymentInfo.value!!.amount.toString())
        content = content.replace("_orderId", viewModel.paymentInfo.value!!.orderId)
        content = content.replace("_orderName", viewModel.paymentInfo.value!!.orderName)
        content = content.replace("_customerName", viewModel.paymentInfo.value!!.customerName)
//        content.replace("_customerEmail", viewModel.paymentInfo.value!!.customerEmail)
        binding.paymentWebView.loadData(content, "text/html", "UTF-8")

    }

}