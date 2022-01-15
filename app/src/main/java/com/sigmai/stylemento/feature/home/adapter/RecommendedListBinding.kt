package com.sigmai.stylemento.feature.home.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.RecommendedCoordinator

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<RecommendedCoordinator>) {
    (listView.adapter as RecommendedCoordinatorAdapter).setList(items)
}