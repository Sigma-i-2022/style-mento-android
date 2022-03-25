package com.sigmai.stylemento.ui.mypage.user.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.data.model.response.lookBook.LookPage

@BindingAdapter("app:lookbooks")
fun submitLookBooks(recyclerView: RecyclerView, list: List<LookbookItem>) {
    (recyclerView.adapter as UserLookbookItemAdapter).submitList(list)
}

@BindingAdapter("app:lookBooks")
fun bindLookBooks(recyclerView: RecyclerView, list: List<LookPage>?) {
    list?.let {
        (recyclerView.adapter as PieceGridAdapter).submitList(list)
    }
}