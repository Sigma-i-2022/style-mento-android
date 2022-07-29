package com.sigmai.stylemento.ui.reservation.list

import android.view.View

interface ReservationListener {
    fun onReview(view: View, seq: Long, position: Int)
    fun onDelete(view: View, seq: Long, email: String)
    fun onSetBuy(view: View, seq: Long, email: String, position: Int)
}