package com.sigmai.stylemento.ui.reservation.cancel

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationCancelUserBinding
import com.sigmai.stylemento.global.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReservationCancelUserFragment : BaseFragment<FragmentReservationCancelUserBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_cancel_user
    private val viewModel: ReservationCancelUserViewModel by viewModels()

    override fun initState() {
        super.initState()
        viewModel.requestCommon(arguments?.getLong("seq") ?: 0)
        viewModel.requestUserInfo(arguments?.getString("email") ?: "")
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigateUp()
        }
        viewModel.startNext.observe(this) {
            viewModel.requestPaymentItem()
            viewModel.postReservationCommonHide()
            findNavController().navigate(R.id.action_reservation_cancel_user_page_to_reservation_cancel_user_complete_page)
        }
        viewModel.endRequestPaymentItem.observe(this) {
            viewModel.requestCancel()
        }
        viewModel.content.observe(this) {
            if (viewModel.content.value!!.length >= 0) {
                binding.reservationCancelUserButton.isEnabled = true
                binding.reservationCancelUserButton.setBackgroundResource(R.drawable.button_available_background)
            } else {
                binding.reservationCancelUserButton.isEnabled = false
                binding.reservationCancelUserButton.setBackgroundResource(R.drawable.button_unavailable_background)
            }
        }
        viewModel.endRequestCommon.observe(this) {
            binding.reservationCancelUserPayWayPriceText.text =
                viewModel.common.value?.price.toString()
            binding.reservationCancelUserServicePriceText.text =
                viewModel.common.value?.price.toString()
        }
    }

}