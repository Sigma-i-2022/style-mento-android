package com.sigmai.stylemento.feature.coordinator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.databinding.ItemCoordinatorBinding
import com.sigmai.stylemento.domain.entity.TempCoordinator
import com.sigmai.stylemento.global.util.GlideUtil

class CoordinatorAdapter : ListAdapter<TempCoordinator, CoordinatorAdapter.CoordinatorViewHolder>(TempDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoordinatorViewHolder {
        return CoordinatorViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CoordinatorViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class CoordinatorViewHolder private constructor(val binding: ItemCoordinatorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TempCoordinator) {
            binding.item = item
            GlideUtil.setImage(item.imageUrl, binding.coordinatorPhoto)
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

class TempDiffCallback : DiffUtil.ItemCallback<TempCoordinator>() {
    override fun areItemsTheSame(oldItem: TempCoordinator, newItem: TempCoordinator): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: TempCoordinator, newItem: TempCoordinator): Boolean {
        return oldItem == newItem
    }
}