package com.sigmai.stylemento.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.databinding.ItemStyleCategoryBinding
import com.sigmai.stylemento.databinding.ItemStyleTagBinding
import com.sigmai.stylemento.ui.mypage.model.StyleTag

class StyleTagSelectionAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list: List<StyleTag> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            StyleTag.CATEGORY -> CategoryViewHolder.from(parent)
            StyleTag.TAG -> TagViewHolder.from(parent)
            else -> throw IllegalArgumentException("unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == StyleTag.CATEGORY) (holder as CategoryViewHolder).bind(list[position])
        else (holder as TagViewHolder).bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return list[position].getType()
    }

    fun submitList(items: List<StyleTag>) {
        list = items
    }

    class CategoryViewHolder private constructor(val binding: ItemStyleCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StyleTag) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : CategoryViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemStyleCategoryBinding.inflate(layoutInflater, parent, false)

                return CategoryViewHolder(binding)
            }
        }
    }

    class TagViewHolder private constructor(val binding: ItemStyleTagBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StyleTag) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : TagViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemStyleTagBinding.inflate(layoutInflater, parent, false)

                return TagViewHolder(binding)
            }
        }
    }
}