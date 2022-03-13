package com.sigmai.stylemento.ui.reservation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ItemReservationUserListBinding
import com.sigmai.stylemento.domain.entity.Receipt
import com.sigmai.stylemento.global.constant.ReceiptStateType


class ReservationUserListAdapter(private val dataSet: List<Receipt>) :
    RecyclerView.Adapter<ReservationUserListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position], this, position)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ViewHolder(val binding: ItemReservationUserListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Receipt, adapter: ReservationUserListAdapter, position: Int) {
            binding.item = item
            setAdapter(item.timeList)
            binding(item)
            setListener(adapter, position)

            binding.executePendingBindings()
        }

        private fun binding(item: Receipt) {
            binding.reservationUserListServicePriceText.text = item.price.toString()
            when (item.state) {
                ReceiptStateType.ACCEPT_BEFORE -> {
                    turnOffShare()
                }
                ReceiptStateType.ACCEPT_AFTER -> {
                    binding.reservationUserListStateText.text = "예약완료"
                    turnOffAccept()
                }
                ReceiptStateType.GET_DECISION -> {
                    binding.reservationUserListStateText.text = "구매확정"
                    binding.reservationUserListCancelButton.visibility = View.GONE
                    binding.reservationUserListDecidedTimeText.visibility = View.VISIBLE
                    binding.reservationUserListDecidedTimeText.text = item.decidedTime
                    binding.reservationUserListTimeRecycler.visibility = View.GONE
                    turnOffShare()
                    turnOffAccept()
                }
                ReceiptStateType.PAYBACK -> {
                    binding.reservationUserListStateText.text = "환불완료/대기"
                    binding.reservationUserListCancelButton.visibility = View.GONE
                    turnOffShare()
                    turnOffAccept()
                }
            }
        }

        private fun setListener(adapter: ReservationUserListAdapter, position: Int) {
            binding.reservationUserListCancelButton.setOnClickListener {
                adapter.notifyItemChanged(position)
            }
            binding.reservationUserListAcceptButton.setOnClickListener {

            }
            binding.reservationUserListShareButton.setOnClickListener {
            }
        }

        private fun setAdapter(timeList: List<String>) {
            binding.reservationUserListTimeRecycler.adapter = TimeAdapter(timeList)
        }

        private fun turnOffAccept() {
            binding.reservationUserListAcceptButton.isEnabled = false
            binding.reservationUserListAcceptButton.setBackgroundResource(R.color.gray_d)
        }

        private fun turnOffShare() {
            binding.reservationUserListShareButton.isEnabled = false
            binding.reservationUserListShareButton.setBackgroundResource(R.color.gray_d)
        }

        companion object {
            fun from(parent: ViewGroup): ReservationUserListAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemReservationUserListBinding.inflate(layoutInflater, parent, false)

                return ReservationUserListAdapter.ViewHolder(binding)
            }
        }
    }

}
