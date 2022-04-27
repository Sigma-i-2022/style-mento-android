package com.sigmai.stylemento.ui.reservation.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationListBinding
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.domain.entity.Receipt
import com.sigmai.stylemento.domain.entity.User
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.constant.ReceiptStateType
import com.sigmai.stylemento.ui.reservation.InfoDialogFragment
import com.sigmai.stylemento.ui.reservation.adapter.ReservationListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReservationListFragment : BaseFragment<FragmentReservationListBinding>() {
    override val layoutResourceId = R.layout.fragment_reservation_list
    private val viewModel: ReservationListViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
        //viewModel.requestReceipts()

        viewModel.startBack.observe(this) {
            findNavController().navigate(R.id.action_reservation_list_page_to_main)
        }
        viewModel.startInfo.observe(this){
            val dialog = InfoDialogFragment()
            dialog.show(childFragmentManager, "info")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coordinator = Coordinator(0, "", "codi1", "codi1_email", "", listOf(), listOf(), 4, listOf(), listOf())
        val user = User(1, "", "user1", "user_email", "", listOf(), listOf())
        val dataSet = listOf<Receipt>(
            Receipt(coordinator, user, "코디추천", "채팅", 3000, "2022.3.17", listOf("9:00", "9:30", "10:00", "10:30"),
                "신용카드", "2022.3.15", "", ReceiptStateType.ACCEPT_BEFORE),
            Receipt(coordinator, user, "코디추천", "채팅", 3000, "2022.3.17", listOf("9:00", "9:30", "10:00", "10:30"),
                "신용카드", "2022.3.15", "", ReceiptStateType.ACCEPT_AFTER),
            Receipt(coordinator, user, "코디추천", "채팅", 3000, "2022.3.17", listOf("9:00", "9:30", "10:00", "10:30"),
                "신용카드", "2022.3.15", "", ReceiptStateType.PAYBACK),
            Receipt(coordinator, user, "코디추천", "채팅", 3000, "2022.3.17", listOf("9:00", "9:30", "10:00", "10:30"),
                "신용카드", "2022.3.15", "10:00", ReceiptStateType.GET_DECISION))
        binding.reservationListRecycler.adapter = ReservationListAdapter(viewModel)

        val stateArray = Array(4){0}
        for(item in dataSet){
            stateArray[item.state] += 1
        }
        binding.reservationListAllText.text = dataSet.size.toString()
        binding.reservationListQueueText.text = stateArray[ReceiptStateType.ACCEPT_BEFORE].toString()
        binding.reservationListCompleteText.text = stateArray[ReceiptStateType.ACCEPT_AFTER].toString()
        binding.reservationListBuyCompleteText.text = stateArray[ReceiptStateType.GET_DECISION].toString()
    }
}