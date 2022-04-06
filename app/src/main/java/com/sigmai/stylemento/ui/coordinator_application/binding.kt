package com.sigmai.stylemento.ui.coordinator_application

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:snsList")
fun bindSns(recyclerView: RecyclerView, list: List<MutableLiveData<String>>?) {
    list?.let {
        (recyclerView.adapter as SnsAdapter).submitList(list)
    }
}
