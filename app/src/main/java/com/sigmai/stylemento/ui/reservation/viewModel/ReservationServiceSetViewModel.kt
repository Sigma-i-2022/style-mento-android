package com.sigmai.stylemento.ui.reservation.viewModel

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.global.util.SingleLiveEvent

class ReservationServiceSetViewModel : ViewModel() {
    val startBack = SingleLiveEvent<Any>()
    val startReservation = SingleLiveEvent<Any>()

    val startFeedback = SingleLiveEvent<Any>()
    val startRecommend = SingleLiveEvent<Any>()
    val startChatting = SingleLiveEvent<Any>()
    val startFaceToFace = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
    fun onReservationClick(){
        startReservation.call()
    }
    fun onFeedbackClick(){
        startFeedback.call()
    }
    fun onRecommendClick(){
        startRecommend.call()
    }
    fun onChattingClick(){
        startChatting.call()
    }
    fun onFaceToFaceClick(){
        startFaceToFace.call()
    }
}