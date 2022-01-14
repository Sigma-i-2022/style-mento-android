package com.sigmai.stylemento.feature.home.notification

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Notification

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