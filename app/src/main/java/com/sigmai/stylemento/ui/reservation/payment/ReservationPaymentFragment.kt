package com.sigmai.stylemento.ui.reservation.payment

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationPaymentBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.TimeUtil
import com.sigmai.stylemento.ui.reservation.adapter.TimeAdapter
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.net.URISyntaxException

@AndroidEntryPoint
class ReservationPaymentFragment : BaseFragment<FragmentReservationPaymentBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_payment
    private val viewModel: ReservationViewModel by viewModels({ requireParentFragment() })

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigateUp()
        }
        viewModel.startNext.observe(this) {
            if (viewModel.payType.value != -1) {
                viewModel.postPayment()
                //shouldOverrideUrlLoading(binding.paymentWebView, "supertoss://")
            }
            TimeUtil.resetTimeList()
            findNavController().navigate(R.id.action_reservation_payment_page_to_reservation_web_view_page)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reservationPaymentServiceTimeRecycler.adapter =
            TimeAdapter(viewModel.client.value!!.reserveTimes, false)

    }
}