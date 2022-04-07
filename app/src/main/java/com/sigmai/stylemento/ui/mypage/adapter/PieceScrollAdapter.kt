package com.sigmai.stylemento.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.databinding.ItemPieceScroll2Binding
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.global.component.SmBottomSheet

class PieceScrollAdapter(val listener: PieceScrollListener) : ListAdapter<Piece, PieceScrollAdapter.ViewHolder>(PieceDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class ViewHolder(val binding: ItemPieceScroll2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(piece: Piece, listener: PieceScrollListener) {
            binding.piece = piece

            binding.moreMenu.setOnClickListener {
                val bottomSheet = SmBottomSheet(it.context)
                bottomSheet.setOnClickListener(
                    {
                        _ ->
                        listener.onEdit(it, piece.id)
                    },
                    {
                        _ ->
                        listener.onDelete(it, piece.id)
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

class PieceDiffUtil : DiffUtil.ItemCallback<Piece>() {
    override fun areItemsTheSame(oldItem: Piece, newItem: Piece): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Piece, newItem: Piece): Boolean {
        return oldItem == newItem
    }
}