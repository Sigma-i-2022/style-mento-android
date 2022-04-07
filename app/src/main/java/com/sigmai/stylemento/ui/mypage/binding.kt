package com.sigmai.stylemento.ui.mypage

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.ui.coordinator.adapter.CoordinatorAdapter
import com.sigmai.stylemento.ui.coordinator.adapter.HorizontalPieceAdapter
import com.sigmai.stylemento.ui.mypage.adapter.PieceScrollAdapter
import com.sigmai.stylemento.ui.mypage.client.adapter.PieceGridAdapter

@BindingAdapter("app:lookBookList")
fun bindLookBookList(recyclerView: RecyclerView, list: List<Piece>?) {
    list?.let {
        (recyclerView.adapter as PieceScrollAdapter).submitList(list)
    }
}

@BindingAdapter("app:coordinators")
fun bindCoordinators(recyclerView: RecyclerView, list: List<Coordinator>) {
    (recyclerView.adapter as CoordinatorAdapter).submitList(list)
}

@BindingAdapter("app:horizontalPiece")
fun bindHorizontalPieces(recyclerView: RecyclerView, list: List<String>) {
    (recyclerView.adapter as HorizontalPieceAdapter).submitList(list)
}

@BindingAdapter("app:lookBooks")
fun bindLookBooks(recyclerView: RecyclerView, list: List<LookPage>?) {
    list?.let {
        (recyclerView.adapter as PieceGridAdapter).submitList(list)
    }
}