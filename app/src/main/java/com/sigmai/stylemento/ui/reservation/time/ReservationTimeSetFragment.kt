package com.sigmai.stylemento.ui.reservation.time

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationTimeSetBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.TimeUtil
import com.sigmai.stylemento.ui.reservation.adapter.TimeSelectorAdapter
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReservationTimeSetFragment : BaseFragment<FragmentReservationTimeSetBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_time_set
    private val viewModel: ReservationViewModel by viewModels({requireParentFragment()})

    var date : String = ""
    override fun initState() {
        super.initState()
        val email = arguments?.getString("Email")!!
        val name = arguments?.getString("Name")!!
        val url = arguments?.getString("Url")!!
        viewModel.setCoordinatorInfo(email, name, url)
    }
    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            TimeUtil.resetTimeList()
            viewModel.clear()
            findNavController().navigateUp()
        }
        viewModel.startNext.observe(this) {
            val bundle = bundleOf("date" to date)
            if(TimeUtil.isSelected())
                findNavController().navigate(R.id.action_reservation_time_page_to_reservation_service_page, bundle)
        }

        setCalendar()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reservationTimeSelectionRecycler.adapter = TimeSelectorAdapter(viewModel)
    }

    private fun setCalendar() {
        val currentTime: Long = System.currentTimeMillis()
        binding.reservationCalendar.minDate = currentTime

        binding.reservationCalendar.setOnDateChangeListener { _, year, month, dayOfMonth ->
            date = "${year}년 ${month+1}월 ${dayOfMonth}일"
        }
    }
}