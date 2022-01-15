package com.sigmai.stylemento.feature.home.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.FavoriteCoordinator
import com.sigmai.stylemento.data.model.RecommendedCoordinator

@BindingAdapter("app:favorites")
fun setItems(listView: RecyclerView, items: List<FavoriteCoordinator>) {
    (listView.adapter as FavoriteCoordinatorAdapter).setList(items)
}