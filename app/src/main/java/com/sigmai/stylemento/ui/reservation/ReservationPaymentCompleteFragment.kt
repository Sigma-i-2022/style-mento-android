package com.sigmai.stylemento.ui.reservation

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

class ReservationPaymentCompleteFragment : BaseFragment<FragmentReservationPaymentCompleteBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_payment_complete
    private val viewModel: ReservationViewModel by viewModels({requireParentFragment()})

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reservationCompletePayWayPriceText.text = viewModel.receipt.value!!.price.toString()
        binding.reservationCompleteServicePriceText.text = viewModel.receipt.value!!.price.toString()
        binding.reservationCompleteServiceTimeRecycler.adapter = TimeAdapter(viewModel.receipt.value!!.timeList)
        Glide.with(this).load(viewModel.coordinator.value?.imageUrl)
            .into(binding.reservationCompleteCoordinatorImg)
    }

}