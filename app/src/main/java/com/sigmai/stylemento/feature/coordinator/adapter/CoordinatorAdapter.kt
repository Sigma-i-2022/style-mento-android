package com.sigmai.stylemento.feature.coordinator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.databinding.ItemCoordinatorBinding

class CoordinatorAdapter : ListAdapter<Coordinator, CoordinatorAdapter.CoordinatorViewHolder>(TempDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoordinatorViewHolder {
        return CoordinatorViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CoordinatorViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class CoordinatorViewHolder private constructor(val binding: ItemCoordinatorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Coordinator) {
            binding.item = item
        }

        companion object {
            fun from(parent: ViewGroup) : CoordinatorViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCoordinatorBinding.inflate(layoutInflater, parent, false)

                return CoordinatorViewHolder(binding)
            }
        }
    }
}

class TempDiffCallback : DiffUtil.ItemCallback<Coordinator>() {
    override fun areItemsTheSame(oldItem: Coordinator, newItem: Coordinator): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Coordinator, newItem: Coordinator): Boolean {
        return oldItem == newItem
    }
}