package com.sigmai.stylemento.ui.mypage.user.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.LookbookItem

@BindingAdapter("app:lookbooks")
fun submitLookBooks(recyclerView: RecyclerView, list: List<LookbookItem>) {
    (recyclerView.adapter as UserLookbookItemAdapter).submitList(list)
}