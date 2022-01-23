package com.sigmai.stylemento.feature.home.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.FavoriteCoordinator
import com.sigmai.stylemento.data.model.Notification
import com.sigmai.stylemento.data.model.RecommendedCoordinator

@BindingAdapter("app:favorites")
fun setFavorites(listView: RecyclerView, items: List<FavoriteCoordinator>) {
    (listView.adapter as FavoriteCoordinatorAdapter).setList(items)
}

@BindingAdapter("app:notifications")
fun setNotifications(listView: RecyclerView, items: List<Notification>) {
    (listView.adapter as NotificationAdapter).setList(items)
}

@BindingAdapter("app:recommendations")
fun setRecommendations(listView: RecyclerView, items: List<RecommendedCoordinator>) {
    (listView.adapter as RecommendedCoordinatorAdapter).setList(items)
}

@BindingAdapter("app:tags")
fun setTags(listView: RecyclerView, items: List<String>) {
    (listView.adapter as TagAdapter).setList(items)
}