package com.sigmai.stylemento.ui.reservation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationListBinding
import com.sigmai.stylemento.databinding.FragmentReservationUserListBinding
import com.sigmai.stylemento.domain.entity.Receipt
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.constant.ReceiptStateType
import com.sigmai.stylemento.ui.reservation.adapter.ReservationListAdapter
import com.sigmai.stylemento.ui.reservation.adapter.ReservationUserListAdapter
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationListViewModel
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationUserListViewModel

class ReservationUserListFragment : BaseFragment<FragmentReservationUserListBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_user_list
    private val viewModel: ReservationUserListViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigate(R.id.action_reservation_user_list_page_to_main)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataSet = listOf<Receipt>()
        binding.reservationUserListRecycler.adapter = ReservationUserListAdapter(dataSet)

        val stateArray = Array(3){0}
        for(item in dataSet){
            stateArray[item.state] += 1
        }
        binding.reservationUserListAllText.text = dataSet.size.toString()
        binding.reservationUserListQueueText.text = stateArray[ReceiptStateType.ACCEPT_BEFORE].toString()
        binding.reservationUserListCompleteText.text = stateArray[ReceiptStateType.ACCEPT_AFTER].toString()
        binding.reservationUserListBuyCompleteText.text = stateArray[ReceiptStateType.GET_DECISION].toString()
    }
}