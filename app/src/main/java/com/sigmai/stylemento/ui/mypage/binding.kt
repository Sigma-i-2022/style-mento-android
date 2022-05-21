package com.sigmai.stylemento.ui.mypage

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.domain.entity.Review
import com.sigmai.stylemento.ui.coordinator.adapter.CoordinatorAdapter
import com.sigmai.stylemento.ui.coordinator.adapter.HorizontalPieceAdapter
import com.sigmai.stylemento.ui.mypage.adapter.CoordinatorReviewAdapter
import com.sigmai.stylemento.ui.mypage.adapter.PieceScrollAdapter
import com.sigmai.stylemento.ui.mypage.client.adapter.PieceGridAdapter
import timber.log.Timber

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

@BindingAdapter("app:reviews")
fun bindReviews(recyclerView: RecyclerView, list: List<Review>?) {
    list?.let {
        (recyclerView.adapter as CoordinatorReviewAdapter).submitList(list)
    }
}

@BindingAdapter("app:selected")
fun bindSelected(view: Button, isSelected: Boolean) {
    var drawable: Drawable? = view.background
    drawable = DrawableCompat.wrap(drawable!!)

    if(isSelected) {
//        view.background = ContextCompat.getDrawable(view.context, R.drawable.background_radius_12)
        DrawableCompat.setTint(drawable, ContextCompat.getColor(view.context, R.color.primary))
        view.setTextColor(view.context.getColor(R.color.white))
    } else {
//        view.background = ContextCompat.getDrawable(view.context, R.drawable.outline_radius_12)
        DrawableCompat.setTint(drawable, ContextCompat.getColor(view.context, R.color.white))
        view.setTextColor(view.context.getColor(R.color.black))
    }
}