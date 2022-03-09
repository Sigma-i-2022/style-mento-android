package com.sigmai.stylemento.ui.home.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.Notification

@BindingAdapter("app:notifications")
fun setNotifications(listView: RecyclerView, items: List<Notification>) {
    (listView.adapter as NotificationAdapter).setList(items)
}