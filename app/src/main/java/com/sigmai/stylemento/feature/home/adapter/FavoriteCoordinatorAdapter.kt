package com.sigmai.stylemento.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.FavoriteCoordinator
import com.sigmai.stylemento.databinding.ItemFavoriteCoordinatorBinding

class FavoriteCoordinatorAdapter() : RecyclerView.Adapter<FavoriteCoordinatorAdapter.FavoriteCoordinatorViewHolder>() {
    var favoriteList: List<FavoriteCoordinator>? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteCoordinatorViewHolder {
        return FavoriteCoordinatorViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: FavoriteCoordinatorViewHolder, position: Int) {
        val item = favoriteList!![position]
        holder.bind(item)
    }

    override fun getItemCount() = favoriteList!!.size

    fun setList(items: List<FavoriteCoordinator>) {
        favoriteList = items
    }

    class FavoriteCoordinatorViewHolder private constructor(val binding: ItemFavoriteCoordinatorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FavoriteCoordinator) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : FavoriteCoordinatorViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemFavoriteCoordinatorBinding.inflate(layoutInflater, parent, false)

                return FavoriteCoordinatorViewHolder(binding)
            }
        }
    }
}