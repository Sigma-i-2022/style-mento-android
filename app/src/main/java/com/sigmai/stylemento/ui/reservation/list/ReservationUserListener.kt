package com.sigmai.stylemento.ui.reservation.list

import android.view.View

interface ReservationUserListener {
    fun onAccept(view: View, seq: Long, email: String, time : String, position: Int)
    fun onDelete(view: View, seq: Long, email: String)
}