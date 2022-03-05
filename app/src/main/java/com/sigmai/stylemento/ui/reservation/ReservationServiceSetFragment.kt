package com.sigmai.stylemento.ui.reservation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.data.model.Receipt
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.databinding.FragmentReservationServiceSetBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationViewModel

class ReservationServiceSetFragment : BaseFragment<FragmentReservationServiceSetBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_service_set
    private val viewModel: ReservationViewModel by viewModels({ requireParentFragment() })

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigateUp()
        }
        viewModel.startNext.observe(this) {
            val receipt = viewModel.receipt
            if(viewModel.serviceType.value == 0) receipt.value!!.serviceName = "스타일 피드백"
            else if(viewModel.serviceType.value == 1) receipt.value!!.serviceName = "구매 추천"
            if(viewModel.serviceWay.value == 0) receipt.value!!.serviceWay = "채팅"
            else if(viewModel.serviceWay.value == 1) receipt.value!!.serviceWay = "화상"
            findNavController().navigate(R.id.action_reservation_service_page_to_reservation_payment_page)
        }
        setImageClick()
        observeInput()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewInit()

        viewModel.setReceipt(Receipt(Coordinator("11"), User("22", "email")))
        binding.reservationServiceRequestEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.setRequestText(p0.toString())
            }
        })
    }
    private fun viewInit(){
        checkButtonEnabled()

        if(viewModel.serviceType.value == 0)
            binding.reservationServiceFeedbackImg.setBackgroundResource(R.drawable.button_background_type_1)
        else if(viewModel.serviceType.value == 1)
            binding.reservationServiceCoordiRecommendationImg.setBackgroundResource(R.drawable.button_background_type_1)
        if(viewModel.serviceWay.value == 0)
            binding.reservationServiceChattingImg.setBackgroundResource(R.drawable.button_background_type_1)
        else if(viewModel.serviceWay.value == 1)
            binding.reservationServiceFaceToFaceImg.setBackgroundResource(R.drawable.button_background_type_1)
    }

    private fun setImageClick(){
        viewModel.startFeedback.observe(this) {
            binding.reservationServiceCoordiRecommendationImg.setBackgroundResource(R.color.trans_parent)
            if (viewModel.serviceType.value == 0)
                binding.reservationServiceFeedbackImg.setBackgroundResource(R.drawable.button_background_type_1)
            else
                binding.reservationServiceFeedbackImg.setBackgroundResource(R.color.trans_parent)
        }
        viewModel.startRecommend.observe(this) {
            binding.reservationServiceFeedbackImg.setBackgroundResource(R.color.trans_parent)
            if (viewModel.serviceType.value == 1)
                binding.reservationServiceCoordiRecommendationImg.setBackgroundResource(R.drawable.button_background_type_1)
            else
                binding.reservationServiceCoordiRecommendationImg.setBackgroundResource(R.color.trans_parent)
        }
        viewModel.startChatting.observe(this) {
            binding.reservationServiceFaceToFaceImg.setBackgroundResource(R.color.trans_parent)
            if (viewModel.serviceWay.value == 0)
                binding.reservationServiceChattingImg.setBackgroundResource(R.drawable.button_background_type_1)
            else
                binding.reservationServiceChattingImg.setBackgroundResource(R.color.trans_parent)
        }
        viewModel.startFaceToFace.observe(this) {
            binding.reservationServiceChattingImg.setBackgroundResource(R.color.trans_parent)
            if (viewModel.serviceWay.value == 1)
                binding.reservationServiceFaceToFaceImg.setBackgroundResource(R.drawable.button_background_type_1)
            else
                binding.reservationServiceFaceToFaceImg.setBackgroundResource(R.color.trans_parent)
        }
    }
    private fun observeInput(){
        viewModel.serviceType.observe(this){
            checkButtonEnabled()
        }
        viewModel.serviceWay.observe(this){
            checkButtonEnabled()
        }
        viewModel.requestText.observe(this){
            checkButtonEnabled()
        }
    }
    private fun checkButtonEnabled(){
        if(viewModel.serviceType.value != -1 && viewModel.serviceWay.value != -1 &&
                viewModel.requestText.value!!.length > 5){
            binding.reservationTimeSelectionNextButton.isEnabled = true
            binding.reservationTimeSelectionNextButton.setBackgroundResource(R.color.primary)
        }
        else{
            binding.reservationTimeSelectionNextButton.isEnabled = false
            binding.reservationTimeSelectionNextButton.setBackgroundResource(R.color.gray_d)
        }
    }
}