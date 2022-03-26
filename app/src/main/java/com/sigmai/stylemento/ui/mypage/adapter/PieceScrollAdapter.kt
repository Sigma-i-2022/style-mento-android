package com.sigmai.stylemento.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.databinding.ItemPieceScroll2Binding
import com.sigmai.stylemento.global.component.SmBottomSheet
import com.sigmai.stylemento.ui.mypage.user.adapter.LookPageDiffUtil

class PieceScrollAdapter(val listener: PieceScrollListener) : ListAdapter<LookPage, PieceScrollAdapter.ViewHolder>(LookPageDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class ViewHolder(val binding: ItemPieceScroll2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LookPage, listener: PieceScrollListener) {
            binding.item = item

            binding.moreMenu.setOnClickListener {
                val bottomSheet = SmBottomSheet(it.context)
                bottomSheet.setOnClickListener(
                    {
                        _ ->
                        listener.onEdit(it, item.lookPageSeq)
                    },
                    {
                        _ ->
                        listener.onDelete(it, item.lookPageSeq)
                    }
                )
                bottomSheet.show()
            }

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