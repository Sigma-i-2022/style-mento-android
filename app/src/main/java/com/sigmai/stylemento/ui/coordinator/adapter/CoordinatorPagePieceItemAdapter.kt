package com.sigmai.stylemento.ui.coordinator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ItemPieceScrollBinding
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.global.component.SmBottomSheet
import com.sigmai.stylemento.ui.coordinator.coordinatorpage.CoordinatorPageViewModel
import com.sigmai.stylemento.ui.home.adapter.TagAdapter

class CoordinatorPagePieceItemAdapter(val viewModel: CoordinatorPageViewModel) : ListAdapter<Piece, CoordinatorPagePieceItemAdapter.ViewHolder>(WorkItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder.from(parent)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), viewModel)
    }

    class ViewHolder(val binding: ItemPieceScrollBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Piece, viewModel: CoordinatorPageViewModel) {
            binding.item = item
            binding.viewModel = viewModel
            setAdapter()
            setListener(item.id, viewModel)

            binding.executePendingBindings()
        }

        private fun setAdapter() {
            binding.itemPieceScrollTagRecycler.adapter = TagAdapter()
        }

        private fun setListener(id: Long, viewModel: CoordinatorPageViewModel) {
            binding.itemPieceScrollDetail.setOnClickListener {
                val maxLine = binding.itemPieceScrollDetail.maxLines
                if (maxLine == 10) binding.itemPieceScrollDetail.maxLines = 2
                else binding.itemPieceScrollDetail.maxLines = 10
            }

            binding.moreMenu.setOnClickListener {
                val bottomSheet = SmBottomSheet(it.context)
                bottomSheet.setOnClickListener({}, {
                    viewModel.deletePiece(id)
                })
                bottomSheet.show()
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