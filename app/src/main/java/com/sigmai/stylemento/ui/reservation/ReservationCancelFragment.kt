package com.sigmai.stylemento.ui.reservation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationCancelBinding
import com.sigmai.stylemento.databinding.FragmentReservationPaymentBinding
import com.sigmai.stylemento.domain.entity.Receipt
import com.sigmai.stylemento.domain.usecase.PostReceiptUseCase
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.TimeUtil
import com.sigmai.stylemento.ui.reservation.adapter.TimeAdapter
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationCancelViewModel
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationViewModel

class ReservationCancelFragment : BaseFragment<FragmentReservationCancelBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_cancel
    private val viewModel: ReservationCancelViewModel by viewModels()

    override fun initState() {
        super.initState()
        val position = arguments?.getInt("position")
//        val receipt = getReceiptUseCase().invoke(position)
//        binding.item = receipt
//        binding.reservationCancelServicePriceText.text = receipt.price.toString()
//        binding.reservationCancelPayWayPriceText.text = receipt.price.toString()
    }
    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigateUp()
        }
        viewModel.startNext.observe(this) {
            findNavController().navigate(R.id.action_reservation_cancel_page_to_reservation_cancel_complete_page)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setEditText()
        checkButtonEnabled("")
    }
    private fun setEditText(){
        var reason = ""
        binding.reservationCancelReasonEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                reason = p0.toString()
                checkButtonEnabled(reason)
            }
        })
    }
    private fun checkButtonEnabled(text : String) {
        if (text.length > 24) {
            binding.reservationCancelButton.isEnabled = true
            binding.reservationCancelButton.setBackgroundResource(R.color.primary)
        } else {
            binding.reservationCancelButton.isEnabled = false
            binding.reservationCancelButton.setBackgroundResource(R.color.gray_d)
        }
    }
}