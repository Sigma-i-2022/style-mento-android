package com.sigmai.stylemento.ui.reservation.payment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationPaymentCompleteBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.reservation.adapter.TimeAdapter
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReservationPaymentCompleteFragment : BaseFragment<FragmentReservationPaymentCompleteBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_payment_complete
    private val viewModel: ReservationViewModel by viewModels({requireParentFragment()})

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigate(R.id.action_reservation_payment_complete_page_to_main)
        }
        viewModel.startNext.observe(this){
            findNavController().navigate(R.id.action_reservation_payment_complete_page_to_reservation_list_page)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reservationCompleteServiceTimeRecycler.adapter = TimeAdapter(viewModel.client.value!!.reserveTimes, false)
    }

}