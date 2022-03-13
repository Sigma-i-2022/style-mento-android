package com.sigmai.stylemento.ui.reservation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            when (item.state) {
                ReceiptStateType.ACCEPT_BEFORE -> {
                    setButtonUnable()
                }
                ReceiptStateType.ACCEPT_AFTER ->{
                    binding.reservationListReviewButton.isEnabled = false
                    binding.reservationListReviewButton.setBackgroundResource(R.color.gray_d)
                }
                ReceiptStateType.GET_DECISION -> {
                    binding.reservationListCancelButton.visibility = View.GONE
                    binding.reservationListDecidedTimeText.visibility = View.VISIBLE
                    binding.reservationListDecidedTimeText.text = item.decidedTime
                    binding.reservationListServiceTimeRecycler.visibility = View.GONE
                    binding.reservationListReviewButton.isEnabled = false
                    binding.reservationListReviewButton.setBackgroundResource(R.color.gray_d)
                }
                ReceiptStateType.PAYBACK -> {
                    binding.reservationListCancelButton.visibility = View.GONE
                    binding.reservationListRequestButton.visibility = View.VISIBLE
                    setButtonUnable()
                }
            }
        }

        private fun setListener(adapter: ReservationListAdapter, position: Int) {
            binding.reservationListCancelButton.setOnClickListener {
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
        private fun setButtonUnable(){
            binding.reservationListBuyButton.isEnabled = false
            binding.reservationListBuyButton.setBackgroundResource(R.color.gray_d)
            binding.reservationListReviewButton.isEnabled = false
            binding.reservationListReviewButton.setBackgroundResource(R.color.gray_d)
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
