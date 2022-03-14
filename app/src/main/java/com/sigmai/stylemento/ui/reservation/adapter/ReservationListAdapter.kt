package com.sigmai.stylemento.ui.reservation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ItemReservationListBinding
import com.sigmai.stylemento.domain.entity.Receipt
import com.sigmai.stylemento.global.constant.ReceiptStateType


class ReservationListAdapter(private val dataSet: List<Receipt>) :
    RecyclerView.Adapter<ReservationListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position], this, position)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ViewHolder(val binding: ItemReservationListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Receipt, adapter: ReservationListAdapter, position: Int) {
            binding.item = item
            setAdapter(item.timeList)
            binding(item)
            setListener(adapter, position)

            binding.executePendingBindings()
        }

        private fun binding(item: Receipt) {
            binding.reservationListServicePriceText.text = item.price.toString()
            when (item.state) {
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
                    binding.reservationListDecidedTimeText.visibility = View.VISIBLE
                    binding.reservationListDecidedTimeText.text = item.decidedTime
                    binding.reservationListServiceTimeRecycler.visibility = View.GONE
                    turnOffBuy()
                }
                ReceiptStateType.PAYBACK -> {
                    binding.reservationListStateText.text = "환불완료/대기"
                    binding.reservationListCancelButton.visibility = View.GONE
                    binding.reservationListRequestButton.visibility = View.VISIBLE
                    turnOffReview()
                    turnOffBuy()
                }
            }
        }

        private fun setListener(adapter: ReservationListAdapter, position: Int) {
            binding.reservationListCancelButton.setOnClickListener {
                it.findNavController().navigate(R.id.action_reservation_list_page_to_reservation_cancel_page)
                adapter.notifyItemChanged(position)
            }
            binding.reservationListRequestButton.setOnClickListener {

            }
            binding.reservationListBuyButton.setOnClickListener {
                adapter.notifyItemChanged(position)
            }
            binding.reservationListReviewButton.setOnClickListener {

            }
        }

        private fun setAdapter(timeList: List<String>) {
            binding.reservationListServiceTimeRecycler.adapter = TimeAdapter(timeList)
        }
        private fun turnOffReview(){
            binding.reservationListReviewButton.isEnabled = false
            binding.reservationListReviewButton.setBackgroundResource(R.color.gray_d)
        }
        private fun turnOffBuy(){
            binding.reservationListBuyButton.isEnabled = false
            binding.reservationListBuyButton.setBackgroundResource(R.color.gray_d)
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
