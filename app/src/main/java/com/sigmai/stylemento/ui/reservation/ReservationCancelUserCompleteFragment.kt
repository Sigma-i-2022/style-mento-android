package com.sigmai.stylemento.ui.reservation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationCancelCompleteBinding
import com.sigmai.stylemento.databinding.FragmentReservationCancelUserCompleteBinding
import com.sigmai.stylemento.databinding.FragmentReservationPaymentCompleteBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.reservation.adapter.TimeAdapter
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationCancelCompleteViewModel
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationCancelUserCompleteViewModel
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationViewModel

class ReservationCancelUserCompleteFragment : BaseFragment<FragmentReservationCancelUserCompleteBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_cancel_user_complete
    private val viewModel: ReservationCancelUserCompleteViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigate(R.id.action_reservation_cancel_complete_page_to_reservation_list_page)
        }
        viewModel.startNext.observe(this){
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}