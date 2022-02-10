package com.sigmai.stylemento.ui.login

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.global.util.SingleLiveEvent

class LoginViewModel : ViewModel() {
    val startNext = SingleLiveEvent<Any>()

    fun onClickSignUp() {
        startNext.call()
    }
}