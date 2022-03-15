package com.sigmai.stylemento.ui.reservation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ItemTimeSelectorBinding


class TimeAdapter(
    private val timeList: List<String>,
    private var clickable: Boolean = false,
    private var selectedTimes: ArrayList<String> = ArrayList()
) : RecyclerView.Adapter<TimeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(timeList[position], selectedTimes, clickable)
    }

    override fun getItemCount(): Int {
        return timeList.size
    }

    class ViewHolder(val binding: ItemTimeSelectorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, selectedTimes: ArrayList<String>, clickable: Boolean) {
            binding.item = item
            if (clickable) binding.timeSelectorText.setOnClickListener { tagView ->
                onClickTime(item, selectedTimes, tagView as TextView)
            }
            binding.executePendingBindings()
        }

        private fun onClickTime(
            item: String,
            selectedTimes: ArrayList<String>,
            timeView: TextView
        ) {
            if (selectedTimes.contains(item)) {
                selectedTimes.remove(item)
                timeView.setBackgroundResource(R.drawable.button_background_type_1)
                return
            }

            if (selectedTimes.size < 1) {
                selectedTimes.add(item)
                timeView.setBackgroundResource(R.drawable.button_background_type_2)
            }
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
