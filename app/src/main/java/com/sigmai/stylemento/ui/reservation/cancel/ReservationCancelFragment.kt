package com.sigmai.stylemento.ui.reservation.cancel

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationCancelBinding
import com.sigmai.stylemento.global.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ReservationCancelFragment : BaseFragment<FragmentReservationCancelBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_cancel
    private val viewModel: ReservationCancelViewModel by viewModels()

    override fun initState() {
        super.initState()
        viewModel.requestCommon(arguments?.getLong("seq") ?: 0)
        viewModel.requestCrdiInfo(arguments?.getString("email") ?: "")
    }
    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigateUp()
        }
        viewModel.startNext.observe(this) {
            viewModel.requestCancel()
            viewModel.postReservationCommonHide()
            findNavController().navigate(R.id.action_reservation_cancel_page_to_reservation_cancel_complete_page)
        }
        viewModel.content.observe(this){
            checkButtonEnabled(viewModel.content.value!!)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkButtonEnabled("")

        binding.reservationCancelPayWayPriceText.text = viewModel.common.value?.price.toString()
        binding.reservationCancelServicePriceText.text = viewModel.common.value?.price.toString()
    }

    private fun checkButtonEnabled(text : String) {
        Timber.d(text)
        if (text.length > 24) {
            binding.reservationCancelButton.isEnabled = true
            binding.reservationCancelButton.setBackgroundResource(R.drawable.button_available_background)
        } else {
            binding.reservationCancelButton.isEnabled = false
            binding.reservationCancelButton.setBackgroundResource(R.drawable.button_unavailable_background)
        }
    }
}