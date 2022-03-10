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


class TimeAdapter(items : List<String>) : RecyclerView.Adapter<TimeAdapter.ViewHolder>() {
    private val dataSet = items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ViewHolder(val binding: ItemTimeSelectorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): TimeAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemTimeSelectorBinding.inflate(layoutInflater, parent, false)

                return TimeAdapter.ViewHolder(binding)
            }
        }
    }

}
