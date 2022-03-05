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


class TimeSelectorAdapter(private val viewModel : ReservationViewModel) : RecyclerView.Adapter<TimeSelectorAdapter.ViewHolder>() {
    private val dataSet = TimeUtil.timeList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position], viewModel)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ViewHolder(val binding: ItemTimeSelectorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TimeItem, viewModel: ReservationViewModel) {
            binding.item = item.time
            binding.timeSelectorImg.setOnClickListener {
                Log.d("curText", item.time)
                Log.d("isChecked", item.isChecked.toString())
                item.isChecked = !item.isChecked

                if(item.isChecked)
                    binding.timeSelectorImg.setImageResource(R.drawable.button_background_type_4)
                else
                    binding.timeSelectorImg.setImageResource(R.drawable.button_background_type_3)
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