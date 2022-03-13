package com.sigmai.stylemento.ui.reservation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationListBinding
import com.sigmai.stylemento.domain.entity.Receipt
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.constant.ReceiptStateType
import com.sigmai.stylemento.ui.reservation.adapter.ReservationListAdapter
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationListViewModel

class ReservationListFragment : BaseFragment<FragmentReservationListBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_list
    private val viewModel: ReservationListViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigate(R.id.action_reservation_list_page_to_main)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataSet = listOf<Receipt>()
        binding.reservationListRecycler.adapter = ReservationListAdapter(dataSet)

        val stateArray = Array(3){0}
        for(item in dataSet){
            stateArray[item.state] += 1
        }
        binding.reservationListAllText.text = dataSet.size.toString()
        binding.reservationListQueueText.text = stateArray[ReceiptStateType.ACCEPT_BEFORE].toString()
        binding.reservationListCompleteText.text = stateArray[ReceiptStateType.ACCEPT_AFTER].toString()
        binding.reservationListBuyCompleteText.text = stateArray[ReceiptStateType.GET_DECISION].toString()
    }
}