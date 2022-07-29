package com.sigmai.stylemento.ui.reservation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.databinding.ItemReservationUserListBinding
import com.sigmai.stylemento.global.constant.ReceiptStateType
import com.sigmai.stylemento.ui.reservation.list.ReservationUserListViewModel
import com.sigmai.stylemento.ui.reservation.list.ReservationUserListener


class ReservationUserListAdapter(val listener : ReservationUserListener) : ListAdapter<Common, ReservationUserListAdapter.ViewHolder>(CommonDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class ViewHolder(val binding: ItemReservationUserListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val selectedTimes = ArrayList<String>()
        fun bind(item: Common, listener : ReservationUserListener) {
            binding.item = item
            setAdapter(item.reserveTimes, false)
            binding(item)
            setListener(item, listener)

            binding.executePendingBindings()
        }

        private fun binding(item: Common) {
            binding.reservationUserListServicePriceText.text = item.price.toString()
            when (getState(item)) {
                ReceiptStateType.ACCEPT_BEFORE -> {
                    turnOffShare()
                    setAdapter(item.reserveTimes, true)
                }
                ReceiptStateType.ACCEPT_AFTER -> {
                    binding.reservationUserListStateText.text = "예약완료"
                    binding.reservationUserListTimeRecycler.visibility = View.GONE
                    showDecidedTime(item.confirmedReserveTime)
                    turnOffAccept()
                }
                ReceiptStateType.GET_DECISION -> {
                    binding.reservationUserListStateText.text = "구매확정"
                    binding.reservationUserListCancelButton.visibility = View.GONE
                    binding.reservationUserListTimeRecycler.visibility = View.GONE
                    showDecidedTime(item.confirmedReserveTime)
                    turnOffShare()
                    turnOffAccept()
                }
                ReceiptStateType.PAYBACK -> {
                    binding.reservationUserListStateText.text = "환불완료/대기"
                    binding.reservationUserListCancelButton.visibility = View.GONE
                    if(item.confirmedReserveTime != ""){
                        showDecidedTime(item.confirmedReserveTime)
                        binding.reservationUserListTimeRecycler.visibility = View.GONE
                    }
                    turnOffShare()
                    turnOffAccept()
                }
            }
        }

        private fun setListener(item: Common, listener : ReservationUserListener) {
            binding.reservationUserListCancelButton.setOnClickListener {
                listener.onDelete(it, item.seq, item.clientEmail)
            }
            binding.reservationUserListAcceptButton.setOnClickListener {
                if(selectedTimes.size > 0) {
                    listener.onAccept(it, item.seq, item.crdiEmail, selectedTimes[0], adapterPosition)
                }
            }
            binding.reservationUserListShareButton.setOnClickListener {
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
