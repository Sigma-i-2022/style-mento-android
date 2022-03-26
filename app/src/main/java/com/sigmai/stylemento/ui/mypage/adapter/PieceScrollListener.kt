package com.sigmai.stylemento.ui.mypage.adapter

import android.view.View

interface PieceScrollListener {
    fun onEdit(view: View, id: Long)
    fun onDelete(view: View, id: Long)
}