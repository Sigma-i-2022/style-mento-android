package com.sigmai.stylemento.ui.reservation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationServiceSetBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.TimeUtil
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationViewModel
import java.text.SimpleDateFormat

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
            setReceipt()
            findNavController().navigate(R.id.action_reservation_service_page_to_reservation_payment_page)
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
                viewModel.setRequestText(p0.toString())
            }
        })
    }

    private fun setReceipt() {
        val serviceName =
            if (viewModel.serviceType.value == 0) "스타일 피드백"
            else "코디 or 구매 추천"
        val serviceWay =
            if (viewModel.serviceWay.value == 0) "문자채팅(오픈채팅)"
            else "화상대면(ZOOM)"

        val date = arguments?.getString("date")!!
        val timeList = TimeUtil.getSelectedTimeList(TimeUtil.timeList)
        val price = 3000

        val currentTime: Long = System.currentTimeMillis()
        val dataFormat = SimpleDateFormat("yyyy.MM.dd")
        val time = dataFormat.format(currentTime)

        //viewModel.setReceipt(Receipt(viewModel.coordinator.value!!, viewModel.user.value!!, serviceName, serviceWay, price, date, timeList, "", time, "", ReceiptStateType.ACCEPT_BEFORE))
    }
}