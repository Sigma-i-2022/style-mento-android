package com.sigmai.stylemento.feature.coordinator.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.domain.entity.TempCoordinator

@BindingAdapter("app:coordinators")
fun setList(recyclerView: RecyclerView, list: List<TempCoordinator>) {
    (recyclerView.adapter as CoordinatorAdapter).submitList(list)
}
