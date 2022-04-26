package com.sigmai.stylemento.ui.reservation.cancel

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.global.util.SingleLiveEvent

class ReservationCancelCompleteViewModel : ViewModel() {
    val startBack = SingleLiveEvent<Any>()
    val startNext = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
    fun onNextClick(){
        startNext.call()
    }
}