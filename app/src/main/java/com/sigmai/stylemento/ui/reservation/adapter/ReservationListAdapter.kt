package com.sigmai.stylemento.ui.reservation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.databinding.ItemReservationListBinding
import com.sigmai.stylemento.domain.entity.Receipt
import com.sigmai.stylemento.global.constant.ReceiptStateType
import com.sigmai.stylemento.global.store.AuthenticationInformation
import com.sigmai.stylemento.ui.reservation.list.ReservationListViewModel


class ReservationListAdapter(val viewModel : ReservationListViewModel) :
    RecyclerView.Adapter<ReservationListAdapter.ViewHolder>() {
    private val dataSet = viewModel.receipts.value!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position], this, position, viewModel)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ViewHolder(val binding: ItemReservationListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Common, adapter: ReservationListAdapter, position: Int, viewModel : ReservationListViewModel) {
            binding.item = item
            setAdapter(item.reserveTimes)
            binding(item)
            setListener(adapter, position, item, viewModel)

            binding.executePendingBindings()
        }

        private fun binding(item: Common) {
            binding.reservationListServicePriceText.text = item.price.toString()
            when (getState(item)) {
                ReceiptStateType.ACCEPT_BEFORE -> {
                    turnOffReview()
                    turnOffBuy()
                }
                ReceiptStateType.ACCEPT_AFTER ->{
                    binding.reservationListStateText.text = "예약완료"
                    turnOffReview()
                }
                ReceiptStateType.GET_DECISION -> {
                    binding.reservationListStateText.text = "구매확정"
                    binding.reservationListCancelButton.visibility = View.GONE
                    binding.reservationListServiceTimeRecycler.visibility = View.GONE
                    showDecidedTime(item.confirmReserveTime)
                    turnOffBuy()
                }
                ReceiptStateType.PAYBACK -> {
                    binding.reservationListStateText.text = "환불완료/대기"
                    binding.reservationListCancelButton.visibility = View.GONE
                    binding.reservationListRequestButton.visibility = View.VISIBLE
                    if(item.confirmReserveTime != "" || item.confirmReserveTime != null){
                        binding.reservationListServiceTimeRecycler.visibility = View.GONE
                        showDecidedTime(item.confirmReserveTime)
                    }
                    turnOffReview()
                    turnOffBuy()
                }
                ReceiptStateType.REVIEW_AFTER -> {
                    binding.reservationListStateText.text = "후기 작성 완료"
                    binding.reservationListCancelButton.visibility = View.GONE
                    binding.reservationListRequestButton.visibility = View.GONE
                    binding.reservationListServiceTimeRecycler.visibility = View.GONE
                    showDecidedTime(item.confirmReserveTime)
                    turnOffReview()
                    turnOffBuy()
                }
            }
        }

        private fun setListener(adapter: ReservationListAdapter, position: Int, item: Common, viewModel : ReservationListViewModel) {
            binding.reservationListCancelButton.setOnClickListener {
                it.findNavController().navigate(R.id.action_reservation_list_page_to_reservation_cancel_page)
                adapter.notifyItemChanged(position)
            }
            binding.reservationListRequestButton.setOnClickListener {

            }
            binding.reservationListBuyButton.setOnClickListener {
                viewModel.postReservationClientPay(AuthenticationInformation.email.value!!, item.seq)
                adapter.notifyItemChanged(position)
            }
            binding.reservationListReviewButton.setOnClickListener {
                it.findNavController().navigate(R.id.action_reservation_list_page_to_write_review_page)
            }
        }
        private fun getState(item : Common) : Int{
            if(item.reviewedYn == "Y"){
                return ReceiptStateType.REVIEW_AFTER
            }
            if(item.confirmPayYn == "Y"){
                return ReceiptStateType.GET_DECISION
            }
            if(item.confirmResvYn == "Y"){
                return ReceiptStateType.ACCEPT_AFTER
            }
            return ReceiptStateType.ACCEPT_BEFORE
        }
        private fun showDecidedTime(time : String){
            binding.reservationListDecidedTimeText.visibility = View.VISIBLE
            binding.reservationListDecidedTimeText.text = time
        }
        private fun setAdapter(timeList: List<String>) {
            binding.reservationListServiceTimeRecycler.adapter = TimeAdapter(timeList)
        }
        private fun turnOffReview(){
            binding.reservationListReviewButton.isEnabled = false
            binding.reservationListReviewButton.setBackgroundResource(R.drawable.button_unavailable_background)
        }
        private fun turnOffBuy(){
            binding.reservationListBuyButton.isEnabled = false
            binding.reservationListBuyButton.setBackgroundResource(R.drawable.button_unavailable_background)
        }
        companion object {
            fun from(parent: ViewGroup): ReservationListAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemReservationListBinding.inflate(layoutInflater, parent, false)

                return ReservationListAdapter.ViewHolder(binding)
            }
        }
    }

}
