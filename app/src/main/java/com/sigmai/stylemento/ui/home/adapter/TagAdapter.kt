package com.sigmai.stylemento.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.databinding.ItemTagBinding

class TagAdapter : RecyclerView.Adapter<TagAdapter.TagViewHolder>() {
    private var tagList: List<String>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        return TagViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.bind(tagList!![position])
    }

    override fun getItemCount() = tagList?.size ?: 0

    fun setList(items: List<String>) {
        tagList = items
    }

    class TagViewHolder private constructor(val binding: ItemTagBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : TagViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemTagBinding.inflate(layoutInflater, parent, false)

                return TagViewHolder(binding)
            }
        }
    }
}