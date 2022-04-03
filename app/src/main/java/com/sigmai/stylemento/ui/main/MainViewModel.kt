package com.sigmai.stylemento.ui.main

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MainViewModel: ViewModel() {
    val onFindCoordinatorEvent = SingleLiveEvent<Any>()
    val onMyPageEvent = SingleLiveEvent<Any>()

    fun onFindCoordinator() {
        onFindCoordinatorEvent.call()
    }

    fun onMyPage() {
        onMyPageEvent.call()
    }
}