package com.sigmai.stylemento.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.databinding.ItemPieceScroll2Binding
import com.sigmai.stylemento.ui.mypage.user.adapter.LookPageDiffUtil

class PieceScrollAdapter : ListAdapter<LookPage, PieceScrollAdapter.ViewHolder>(LookPageDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(val binding: ItemPieceScroll2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LookPage) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPieceScroll2Binding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}