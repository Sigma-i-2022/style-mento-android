package com.sigmai.stylemento.ui.reservation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.databinding.ItemReservationListBinding
import com.sigmai.stylemento.global.constant.ReceiptStateType
import com.sigmai.stylemento.ui.reservation.list.ReservationListener
import java.util.*


class ReservationListAdapter(val listener : ReservationListener) : ListAdapter<Common, ReservationListAdapter.ViewHolder>(CommonDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class ViewHolder(val binding: ItemReservationListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Common, listener : ReservationListener) {
            binding.item = item
            setAdapter(item.reserveTimes)
            binding(item)
            setListener(item, listener)

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
                    binding.reservationListServiceTimeRecycler.visibility = View.GONE
                    showDecidedTime(item.confirmedReserveTime)
                    turnOffReview()
                }
                ReceiptStateType.GET_DECISION -> {
                    binding.reservationListStateText.text = "구매확정"
                    binding.reservationListCancelButton.visibility = View.GONE
                    binding.reservationListServiceTimeRecycler.visibility = View.GONE
                    showDecidedTime(item.confirmedReserveTime)
                    turnOffBuy()
                }
                ReceiptStateType.PAYBACK -> {
                    binding.reservationListStateText.text = "환불완료/대기"
                    binding.reservationListCancelButton.visibility = View.GONE
                    binding.reservationListRequestButton.visibility = View.VISIBLE
                    if(item.confirmedReserveTime != "" || item.confirmedReserveTime != null){
                        binding.reservationListServiceTimeRecycler.visibility = View.GONE
                        showDecidedTime(item.confirmedReserveTime)
                    }
                    turnOffReview()
                    turnOffBuy()
                }
                ReceiptStateType.REVIEW_AFTER -> {
                    binding.reservationListStateText.text = "후기 작성 완료"
                    binding.reservationListCancelButton.visibility = View.GONE
                    binding.reservationListRequestButton.visibility = View.GONE
                    binding.reservationListServiceTimeRecycler.visibility = View.GONE
                    showDecidedTime(item.confirmedReserveTime)
                    turnOffReview()
                    turnOffBuy()
                }
            }
        }

        private fun setListener(item: Common, listener : ReservationListener) {
            binding.reservationListCancelButton.setOnClickListener {
                listener.onDelete(it, item.seq, item.crdiEmail)
            }
            binding.reservationListRequestButton.setOnClickListener {

            }
            binding.reservationListBuyButton.setOnClickListener {
                listener.onSetBuy(it, item.seq, item.clientEmail, adapterPosition)
            }
            binding.reservationListReviewButton.setOnClickListener {
                listener.onReview(it, item.seq, adapterPosition)
            }
        }
        private fun getState(item : Common) : Int{
            if(item.cancelYn == "Y"){
                return ReceiptStateType.PAYBACK
            }
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

class CommonDiffUtil : DiffUtil.ItemCallback<Common>() {
    override fun areItemsTheSame(oldItem: Common, newItem: Common): Boolean {
        return oldItem.seq == newItem.seq
    }

    override fun areContentsTheSame(oldItem: Common, newItem: Common): Boolean {
        return oldItem == newItem
    }
}
