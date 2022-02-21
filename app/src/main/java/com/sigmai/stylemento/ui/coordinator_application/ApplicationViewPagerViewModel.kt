package com.sigmai.stylemento.ui.coordinator_application

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.global.util.SingleLiveEvent

class ApplicationViewPagerViewModel : ViewModel() {
    val moveNextPageEvent = SingleLiveEvent<Any>()

    fun onClickNext() {
        moveNextPageEvent.call()
    }
}