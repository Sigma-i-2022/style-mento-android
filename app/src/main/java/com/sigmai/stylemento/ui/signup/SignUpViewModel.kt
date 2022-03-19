package com.sigmai.stylemento.ui.signup

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {
    val nextEvent = SingleLiveEvent<Any>()
    val previousEvent = SingleLiveEvent<Any>()

    fun onPrevious() {
        previousEvent.call()
    }

    fun onNext() {
        nextEvent.call()
    }
}