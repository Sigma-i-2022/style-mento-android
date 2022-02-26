package com.sigmai.stylemento.ui.coordinator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.databinding.ItemCoordinatorBinding
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.ui.home.adapter.TagAdapter
import com.sigmai.stylemento.global.util.GlideUtil

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
            GlideUtil.setImageWithRadius(item.imageUrl, binding.coordinatorPhoto, 12)
            binding.coordinatorTags.adapter = TagAdapter()
            binding.pieceList.adapter = HorizontalPieceAdapter()
            binding.executePendingBindings()
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