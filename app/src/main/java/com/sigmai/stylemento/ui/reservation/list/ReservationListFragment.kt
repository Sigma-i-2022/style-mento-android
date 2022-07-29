package com.sigmai.stylemento.ui.reservation.list

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentReservationListBinding
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

        setAdapter()
        viewModel.startBack.observe(this) {
            findNavController().navigate(R.id.action_reservation_list_page_to_main)
        }
        viewModel.startInfo.observe(this){
            val dialog = InfoDialogFragment()
            dialog.show(childFragmentManager, "info")
        }
        viewModel.startAdapter.observe(this){
            setOverView()
        }
        viewModel.adapterPosition.observe(this) {
            binding.reservationListRecycler.scrollToPosition(it)
        }
    }
    override fun initState() {
        viewModel.loadData(0)
    }

    private fun setAdapter(){
        binding.reservationListRecycler.adapter = ReservationListAdapter(viewModel)
    }
    private fun setOverView(){
        val stateArray = Array(4){0}
        for(item in viewModel.commons.value!!){
            if(item.confirmPayYn == "Y"){
                stateArray[ReceiptStateType.GET_DECISION]++
            }
            else if(item.confirmResvYn == "Y"){
                stateArray[ReceiptStateType.ACCEPT_AFTER]++
            }
            else
                stateArray[ReceiptStateType.ACCEPT_BEFORE]++
        }

        binding.reservationListAllText.text = viewModel.commons.value!!.size.toString()
        binding.reservationListQueueText.text = stateArray[ReceiptStateType.ACCEPT_BEFORE].toString()
        binding.reservationListCompleteText.text = stateArray[ReceiptStateType.ACCEPT_AFTER].toString()
        binding.reservationListBuyCompleteText.text = stateArray[ReceiptStateType.GET_DECISION].toString()
    }
}