package com.sigmai.stylemento.ui.reservation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationPaymentBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.reservation.adapter.TimeAdapter
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationViewModel

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
        observeSelection()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkButtonEnabled()
        viewInit()
    }
    private fun viewInit(){
        binding.reservationPaymentServicePriceText.text = viewModel.receipt.value!!.price.toString()
        binding.reservationPaymentServiceTimeRecycler.adapter = TimeAdapter(viewModel.receipt.value!!.timeList)

        if(viewModel.isAllSelected.value!!)
            binding.reservationPaymentAllAgreeImg.setBackgroundResource(R.drawable.button_background_type_1)
        else
            binding.reservationPaymentAllAgreeImg.setBackgroundResource(R.color.trans_parent)
        if(viewModel.isAllSelected.value!!)
            binding.reservationPaymentFirstAgreeImg.setBackgroundResource(R.drawable.button_background_type_1)
        else
            binding.reservationPaymentFirstAgreeImg.setBackgroundResource(R.color.trans_parent)
        if(viewModel.isAllSelected.value!!)
            binding.reservationPaymentSecondAgreeImg.setBackgroundResource(R.drawable.button_background_type_1)
        else
            binding.reservationPaymentSecondAgreeImg.setBackgroundResource(R.color.trans_parent)
    }
    private fun observeSelection(){
        viewModel.isAllSelected.observe(this){
            if(viewModel.isAllSelected.value!!)
                binding.reservationPaymentAllAgreeImg.setBackgroundResource(R.drawable.button_background_type_1)
            else
                binding.reservationPaymentAllAgreeImg.setBackgroundResource(R.color.trans_parent)
            checkButtonEnabled()
        }
        viewModel.isFirstSelected.observe(this){
            if(viewModel.isFirstSelected.value!!)
                binding.reservationPaymentFirstAgreeImg.setBackgroundResource(R.drawable.button_background_type_1)
            else
                binding.reservationPaymentFirstAgreeImg.setBackgroundResource(R.color.trans_parent)
            checkButtonEnabled()
        }
        viewModel.isSecondSelected.observe(this){
            if(viewModel.isSecondSelected.value!!)
                binding.reservationPaymentSecondAgreeImg.setBackgroundResource(R.drawable.button_background_type_1)
            else
                binding.reservationPaymentSecondAgreeImg.setBackgroundResource(R.color.trans_parent)
            checkButtonEnabled()
        }
    }
    private fun checkButtonEnabled(){
        if(viewModel.isAllSelected.value!!){
            binding.reservationPaymentNextButton.isEnabled = true
            binding.reservationPaymentNextButton.setBackgroundResource(R.color.primary)
        }
        else{
            binding.reservationPaymentNextButton.isEnabled = false
            binding.reservationPaymentNextButton.setBackgroundResource(R.color.gray_d)
        }
    }
}