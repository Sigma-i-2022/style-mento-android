package com.sigmai.stylemento.feature.coordinator.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.Coordinator

@BindingAdapter("app:coordinators")
fun setList(recyclerView: RecyclerView, list: List<Coordinator>) {
    (recyclerView.adapter as CoordinatorAdapter).submitList(list)
}
