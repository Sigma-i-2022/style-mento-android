package com.sigmai.stylemento.feature.home.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.FavoriteCoordinator
import com.sigmai.stylemento.data.model.Notification

@BindingAdapter("app:notifications")
fun setItems(listView: RecyclerView, items: List<Notification>) {
    (listView.adapter as NotificationAdapter).setList(items)
}