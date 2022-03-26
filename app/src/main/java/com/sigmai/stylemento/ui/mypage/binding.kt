package com.sigmai.stylemento.ui.mypage

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.ui.mypage.adapter.PieceScrollAdapter

@BindingAdapter("app:lookBookList")
fun bindLookBookList(recyclerView: RecyclerView, list: List<LookPage>?) {
    list?.let {
        (recyclerView.adapter as PieceScrollAdapter).submitList(list)
    }
}