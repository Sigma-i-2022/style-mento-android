package com.sigmai.stylemento.ui.coordinator.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ItemPieceScrollBinding
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.global.component.SmBottomSheet
import com.sigmai.stylemento.ui.coordinator.CoordinatorPageViewModel
import com.sigmai.stylemento.ui.home.adapter.TagAdapter

class CoordinatorPagePieceItemAdapter : ListAdapter<Piece, CoordinatorPagePieceItemAdapter.ViewHolder>(WorkItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(val binding: ItemPieceScrollBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var detailState = 0
        fun bind(item: Piece) {
            binding.item = item
            if(item.isModified)
                binding.itemPieceScrollModifiedText.text = "(수정됨)"
            setImage(item)
            setAdapter(item)
            setListener()

            binding.executePendingBindings()
        }

        private fun setAdapter(item: Piece) {
            val tagAdapter = TagAdapter()
            tagAdapter.setList(item.tags)
            binding.itemPieceScrollTagRecycler.adapter = tagAdapter
        }

        private fun setImage(item: Piece) {
            Glide.with(binding.itemPieceScrollImg).load(item.imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.itemPieceScrollImg)
        }

        private fun setListener() {
            binding.itemPieceScrollDetail.setOnClickListener {
                if (detailState == 0) {
                    binding.itemPieceScrollDetail.maxLines = 10
                    detailState = 1
                } else {
                    binding.itemPieceScrollDetail.maxLines = 2
                    detailState = 0
                }
            }

            binding.moreMenu.setOnClickListener {
                SmBottomSheet(it.context).show()
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPieceScrollBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

// TODO : 임시 구현으로 나중에 id 값 비교 등으로 수정해야 함.
class WorkItemDiffCallback : DiffUtil.ItemCallback<Piece>() {
    override fun areItemsTheSame(oldItem: Piece, newItem: Piece): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Piece, newItem: Piece): Boolean {
        return oldItem == newItem
    }
}