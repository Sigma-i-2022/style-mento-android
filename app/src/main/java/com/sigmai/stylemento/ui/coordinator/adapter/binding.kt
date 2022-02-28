package com.sigmai.stylemento.ui.coordinator.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.domain.entity.Coordinator

@BindingAdapter("app:coordinators")
fun setCoordinators(recyclerView: RecyclerView, list: List<Coordinator>) {
    (recyclerView.adapter as CoordinatorAdapter).submitList(list)
}

@BindingAdapter("app:horizontalPiece")
fun setHorizontalPieces(recyclerView: RecyclerView, list: List<Piece>) {
    (recyclerView.adapter as HorizontalPieceAdapter).setList(list)
}

@BindingAdapter("app:gridPiece")
fun setGridPieces(recyclerView: RecyclerView, list:List<Piece>){
    (recyclerView.adapter as CoordinatorPageWorkAdapter).setDataSet(list)
}