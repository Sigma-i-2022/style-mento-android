package com.sigmai.stylemento.ui.reservation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationPaymentBinding
import com.sigmai.stylemento.databinding.FragmentReservationServiceSetBinding
import com.sigmai.stylemento.databinding.FragmentReservationTimeSetBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationServiceSetViewModel
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationTimeSetViewModel
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationViewModel
import java.text.SimpleDateFormat

class ReservationPaymentFragment : BaseFragment<FragmentReservationPaymentBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_payment
    private val viewModel: ReservationViewModel by viewModels({requireParentFragment()})

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigateUp()
        }
        viewModel.startNext.observe(this) {
            findNavController().navigate(R.id.action_reservation_payment_page_to_reservation_payment_complete_page)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}