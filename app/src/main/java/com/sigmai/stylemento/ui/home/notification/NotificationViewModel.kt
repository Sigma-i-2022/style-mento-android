package com.sigmai.stylemento.ui.home.notification

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Notification
import com.sigmai.stylemento.global.util.SingleLiveEvent

class NotificationViewModel : ViewModel() {
    val dummyList = listOf(
        Notification("eqkfeq_te님이 나를 어쩌구했어요1"),
        Notification("eqkfeq_te님이 나를 어쩌구했어용2"),
        Notification("eqkfeq_te님이 나를 어쩌구했어요3"),
        Notification("eqkfeq_te님이 나를 어쩌구했어용4"),
        Notification("eqkfeq_te님이 나를 어쩌구했어요5"),
        Notification("eqkfeq_te님이 나를 어쩌구했어요6")
    )
}