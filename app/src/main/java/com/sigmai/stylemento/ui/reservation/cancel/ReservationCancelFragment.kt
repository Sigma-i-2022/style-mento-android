package com.sigmai.stylemento.ui.reservation.cancel

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationCancelBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.BankUtil
import com.sigmai.stylemento.ui.setting.BankBottomSheet
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
            viewModel.requestPaymentItem()
            viewModel.postReservationCommonHide()
            findNavController().navigate(R.id.action_reservation_cancel_page_to_reservation_cancel_complete_page)
        }
        viewModel.startSetBank.observe(this) {
            val bankBottomSheet = BankBottomSheet {
                if (it >= 0) {
                    viewModel.bank.value = BankUtil.getBank(it)
                }
            }
            bankBottomSheet.show(childFragmentManager, "dialog")
        }
        viewModel.endRequetPaymentItem.observe(this){
            viewModel.requestCancel()
        }
        viewModel.content.observe(this){
            if (viewModel.content.value!!.length >= 0) {
                binding.reservationCancelButton.isEnabled = true
                binding.reservationCancelButton.setBackgroundResource(R.drawable.button_available_background)
            } else {
                binding.reservationCancelButton.isEnabled = false
                binding.reservationCancelButton.setBackgroundResource(R.drawable.button_unavailable_background)
            }
        }
        binding.reservationCancelPayWayPriceText.text = viewModel.common.value?.price.toString()
        binding.reservationCancelServicePriceText.text = viewModel.common.value?.price.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}