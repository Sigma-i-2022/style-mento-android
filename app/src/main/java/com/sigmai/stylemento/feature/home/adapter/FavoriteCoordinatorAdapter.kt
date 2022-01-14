package com.sigmai.stylemento.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.FavoriteCoordinator
import com.sigmai.stylemento.databinding.ItemFavoriteCoordinatorBinding

class FavoriteCoordinatorAdapter(val coordinatorList: List<String>) : RecyclerView.Adapter<FavoriteCoordinatorAdapter.FavoriteCoordinatorViewHolder>() {
    var favoriteList: List<FavoriteCoordinator>? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteCoordinatorViewHolder {
        return FavoriteCoordinatorViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: FavoriteCoordinatorViewHolder, position: Int) {
        //holder.imageView
    }

    override fun getItemCount() = coordinatorList.size

    fun setList(items: List<FavoriteCoordinator>) {
        favoriteList = items
    }

    class FavoriteCoordinatorViewHolder(val view: View, val binding: ItemFavoriteCoordinatorBinding) : RecyclerView.ViewHolder(view) {
        val imageView = view.findViewById<ImageView>(R.id.favorite_coordinator_photo)

        companion object {
            fun from(parent: ViewGroup) : FavoriteCoordinatorViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemFavoriteCoordinatorBinding.inflate(layoutInflater)

                return FavoriteCoordinatorViewHolder(binding.root, binding)
            }
        }
    }
}