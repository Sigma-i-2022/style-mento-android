package com.sigmai.stylemento.ui.coordinator.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.ui.mypage.adapter.PieceScrollAdapter

@BindingAdapter("app:coordinators")
fun setCoordinators(recyclerView: RecyclerView, list: List<Coordinator>) {
    (recyclerView.adapter as CoordinatorAdapter).submitList(list)
}

@BindingAdapter("app:horizontalPiece")
fun setHorizontalPieces(recyclerView: RecyclerView, list: List<Piece>) {
    (recyclerView.adapter as HorizontalPieceAdapter).setList(list)
}

@BindingAdapter("app:gridPiece")
fun setGridPieces(recyclerView: RecyclerView, list:List<Piece>?){
    (recyclerView.adapter as CoordinatorPageWorkAdapter).setDataSet(list)
}

@BindingAdapter("app:pieces")
fun setPieces(recyclerView: RecyclerView, list:List<Piece>?){
    (recyclerView.adapter as CoordinatorPagePieceItemAdapter).submitList(list)
}

@BindingAdapter("app:pieceList")
fun bindPieceList(recyclerView: RecyclerView, list:List<LookPage>?) {
    list?.let {
        (recyclerView.adapter as PieceScrollAdapter).submitList(list)
    }
}