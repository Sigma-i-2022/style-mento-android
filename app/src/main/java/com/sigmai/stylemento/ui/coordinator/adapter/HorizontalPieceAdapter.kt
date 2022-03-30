package com.sigmai.stylemento.ui.coordinator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.databinding.ItemPieceBinding
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.global.util.GlideUtil

class HorizontalPieceAdapter : ListAdapter<String, HorizontalPieceAdapter.HorizontalPieceViewHolder>(StringDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalPieceViewHolder {
        return HorizontalPieceViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HorizontalPieceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HorizontalPieceViewHolder(val binding: ItemPieceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : HorizontalPieceViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPieceBinding.inflate(layoutInflater, parent, false)

                return HorizontalPieceViewHolder(binding)
            }
        }
    }
}

class StringDiffUtil() : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}