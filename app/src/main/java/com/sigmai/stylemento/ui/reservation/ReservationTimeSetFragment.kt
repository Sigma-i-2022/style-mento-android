package com.sigmai.stylemento.ui.reservation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.repository.datasource.DummyCoordinatorDataSource
import com.sigmai.stylemento.databinding.FragmentReservationTimeSetBinding
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationTimeSetViewModel
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationViewModel
import java.text.SimpleDateFormat

class ReservationTimeSetFragment : BaseFragment<FragmentReservationTimeSetBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_time_set
    private val viewModel: ReservationViewModel by viewModels({requireParentFragment()})

    private var position = 0
    override fun initState() {
        super.initState()
        position = arguments?.getInt("position")!!
        viewModel.getCoordinatorInfo(position)
    }
    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigateUp()
        }
        viewModel.startNext.observe(this) {
            findNavController().navigate(R.id.action_reservation_time_page_to_reservation_service_page)
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