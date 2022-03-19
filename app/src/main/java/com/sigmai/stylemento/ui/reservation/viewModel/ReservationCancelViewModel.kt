package com.sigmai.stylemento.ui.reservation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.global.util.SingleLiveEvent

class ReservationCancelViewModel : ViewModel() {
    val content = MutableLiveData<String>("")

    val startBack = SingleLiveEvent<Any>()
    val startNext = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
    fun onNextClick(){
        startNext.call()
    }
}