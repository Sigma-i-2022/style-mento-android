package com.sigmai.stylemento.ui.reservation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationTimeSetBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationTimeSetViewModel
import java.text.SimpleDateFormat

class ReservationTimeSetFragment : BaseFragment<FragmentReservationTimeSetBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_time_set
    private val viewModel: ReservationTimeSetViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {

        }
        viewModel.startNext.observe(this) {

        }

        setCalendar()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    fun setCalendar() {
        val currentTime: Long = System.currentTimeMillis()
        binding.reservationCalendar.minDate = currentTime

        var time: String = ""
        binding.reservationCalendar.setOnDateChangeListener { _, year, month, dayOfMonth ->
            if (month < 9) {
                if (dayOfMonth < 10) {
                    time = "" + SimpleDateFormat("yyyyMMdd").parse("" + year + 0 + (month + 1) + 0 + dayOfMonth).time
                }
                else {
                    time = "" + SimpleDateFormat("yyyyMMdd").parse("" + year + 0 + (month + 1) + dayOfMonth).time
                }
            } else {
                if (dayOfMonth < 10) {
                    time = "" + SimpleDateFormat("yyyyMMdd").parse("" + year + (month + 1) + 0 + dayOfMonth).time
                }
                else {
                    time = "" + SimpleDateFormat("yyyyMMdd").parse("" + year + (month + 1) + dayOfMonth).time
                }
            }
        }
    }
}