package com.sigmai.stylemento.ui.reservation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
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
        private val selectedTimes = ArrayList<String>()
        fun bind(item: Receipt, adapter: ReservationUserListAdapter, position: Int) {
            binding.item = item
            setAdapter(item.timeList, false)
            binding(item)
            setListener(adapter, position)

            binding.executePendingBindings()
        }

        private fun binding(item: Receipt) {
            binding.reservationUserListServicePriceText.text = item.price.toString()
            when (item.state) {
                ReceiptStateType.ACCEPT_BEFORE -> {
                    turnOffShare()
                    setAdapter(item.timeList, true)
                }
                ReceiptStateType.ACCEPT_AFTER -> {
                    binding.reservationUserListStateText.text = "예약완료"
                    binding.reservationUserListTimeRecycler.visibility = View.GONE
                    showDecidedTime(item.decidedTime)
                    turnOffAccept()
                }
                ReceiptStateType.GET_DECISION -> {
                    binding.reservationUserListStateText.text = "구매확정"
                    binding.reservationUserListCancelButton.visibility = View.GONE
                    binding.reservationUserListTimeRecycler.visibility = View.GONE
                    showDecidedTime(item.decidedTime)
                    turnOffShare()
                    turnOffAccept()
                }
                ReceiptStateType.PAYBACK -> {
                    binding.reservationUserListStateText.text = "환불완료/대기"
                    binding.reservationUserListCancelButton.visibility = View.GONE
                    if(item.decidedTime != ""){
                        showDecidedTime(item.decidedTime)
                        binding.reservationUserListTimeRecycler.visibility = View.GONE
                    }
                    turnOffShare()
                    turnOffAccept()
                }
            }
        }

        private fun setListener(adapter: ReservationUserListAdapter, position: Int) {
            binding.reservationUserListCancelButton.setOnClickListener {
                it.findNavController().navigate(R.id.action_reservation_user_list_page_to_reservation_cancel_user_page)
                adapter.notifyItemChanged(position)
            }
            binding.reservationUserListAcceptButton.setOnClickListener {
                if(selectedTimes.size > 0)
                    binding.reservationUserListTimeText.text = selectedTimes[0] //test용
            }
            binding.reservationUserListShareButton.setOnClickListener {
            }
        }

        private fun setAdapter(timeList: List<String>, clickable : Boolean) {
            binding.reservationUserListTimeRecycler.adapter = TimeAdapter(timeList, clickable, selectedTimes)
        }

        private fun showDecidedTime(time : String){
            binding.reservationUserListDecidedTimeText.visibility = View.VISIBLE
            binding.reservationUserListDecidedTimeText.text = time
        }

        private fun turnOffAccept() {
            binding.reservationUserListAcceptButton.isEnabled = false
            binding.reservationUserListAcceptButton.setBackgroundResource(R.drawable.button_unavailable_background)
        }

        private fun turnOffShare() {
            binding.reservationUserListShareButton.isEnabled = false
            binding.reservationUserListShareButton.setBackgroundResource(R.drawable.button_unavailable_background)
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
