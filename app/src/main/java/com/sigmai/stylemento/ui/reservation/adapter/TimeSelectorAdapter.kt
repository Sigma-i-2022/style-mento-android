package com.sigmai.stylemento.ui.reservation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.TimeItem
import com.sigmai.stylemento.databinding.ItemTimeSelectorBinding
import com.sigmai.stylemento.global.util.TimeUtil
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationViewModel


class TimeSelectorAdapter(viewModel: ReservationViewModel) : RecyclerView.Adapter<TimeSelectorAdapter.ViewHolder>() {
    private val dataSet = TimeUtil.timeList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position], this, position)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ViewHolder(val binding: ItemTimeSelectorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TimeItem, adapter: TimeSelectorAdapter, position: Int) {
            binding.item = item.time

            if(item.isChecked) binding.timeSelectorText.setBackgroundResource(R.drawable.button_background_type_2)
            else binding.timeSelectorText.setBackgroundResource(R.drawable.button_background_type_1)

            binding.root.setOnClickListener {
                item.isChecked = !item.isChecked
                adapter.notifyItemChanged(position)
            }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): TimeSelectorAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemTimeSelectorBinding.inflate(layoutInflater, parent, false)

                return TimeSelectorAdapter.ViewHolder(binding)
            }
        }
    }

}
