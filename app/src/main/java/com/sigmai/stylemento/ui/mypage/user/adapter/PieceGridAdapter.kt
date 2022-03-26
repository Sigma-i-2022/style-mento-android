package com.sigmai.stylemento.ui.mypage.user.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.databinding.ItemGridPieceBinding

class PieceGridAdapter : ListAdapter<LookPage, PieceGridAdapter.ViewHolder>(LookPageDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(val binding: ItemGridPieceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LookPage) {
            binding.item = item
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                val bundle = bundleOf("position" to adapterPosition)
                it.findNavController().navigate(R.id.action_main_to_piece_scroll2, bundle)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemGridPieceBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class LookPageDiffUtil : DiffUtil.ItemCallback<LookPage>() {
    override fun areItemsTheSame(oldItem: LookPage, newItem: LookPage): Boolean {
        return oldItem.lookPageSeq == newItem.lookPageSeq
    }

    override fun areContentsTheSame(oldItem: LookPage, newItem: LookPage): Boolean {
        return oldItem == newItem
    }
}