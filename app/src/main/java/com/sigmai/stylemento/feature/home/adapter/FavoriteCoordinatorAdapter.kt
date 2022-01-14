package com.sigmai.stylemento.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.FavoriteCoordinator

class FavoriteCoordinatorAdapter(val coordinatorList: List<String>) : RecyclerView.Adapter<FavoriteCoordinatorAdapter.FavoriteCoordinatorViewHolder>() {
    var favoriteList: List<FavoriteCoordinator>? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteCoordinatorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite_coordinator, parent, false)
        return FavoriteCoordinatorViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteCoordinatorViewHolder, position: Int) {
        //holder.imageView
    }

    override fun getItemCount() = coordinatorList.size

    fun setList(items: List<FavoriteCoordinator>) {
        favoriteList = items
    }

    inner class FavoriteCoordinatorViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.findViewById<ImageView>(R.id.favorite_coordinator_photo)
    }
}