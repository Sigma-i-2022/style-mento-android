package com.sigmai.stylemento.feature.coordinator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.databinding.ItemPieceBinding
import com.sigmai.stylemento.global.util.GlideUtil

class HorizontalPieceAdapter : RecyclerView.Adapter<HorizontalPieceAdapter.HorizontalPieceViewHolder>() {
    private val pieceList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalPieceViewHolder {
        return HorizontalPieceViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HorizontalPieceViewHolder, position: Int) {
        holder.bind(pieceList[position])
    }

    override fun getItemCount() = pieceList.size

    fun setList(list: List<String>) {
        pieceList.clear()
        pieceList.addAll(list)
    }

    class HorizontalPieceViewHolder(val binding: ItemPieceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            GlideUtil.setImageWithRadius(GlideUtil.getRandomImageUrl(), binding.piecePicture, 12)
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