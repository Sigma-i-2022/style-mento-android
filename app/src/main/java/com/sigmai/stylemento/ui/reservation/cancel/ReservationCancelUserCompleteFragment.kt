package com.sigmai.stylemento.ui.reservation.cancel

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationCancelUserCompleteBinding
import com.sigmai.stylemento.global.base.BaseFragment

class ReservationCancelUserCompleteFragment : BaseFragment<FragmentReservationCancelUserCompleteBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_cancel_user_complete
    private val viewModel: ReservationCancelUserCompleteViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigate(R.id.action_reservation_cancel_user_complete_page_to_reservation_user_list_page)
        }
        viewModel.startNext.observe(this){
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}