package com.sigmai.stylemento.ui.reservation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationServiceSetBinding
import com.sigmai.stylemento.databinding.FragmentReservationTimeSetBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationServiceSetViewModel
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationTimeSetViewModel
import java.text.SimpleDateFormat

class ReservationServiceSetFragment : BaseFragment<FragmentReservationServiceSetBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_service_set
    private val viewModel: ReservationServiceSetViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {

        }
        viewModel.startReservation.observe(this) {

        }
        viewModel.startFeedback.observe(this){

        }
        viewModel.startRecommend.observe(this){

        }
        viewModel.startChatting.observe(this){

        }
        viewModel.startFaceToFace.observe(this){

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reservationServiceRequestEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

}