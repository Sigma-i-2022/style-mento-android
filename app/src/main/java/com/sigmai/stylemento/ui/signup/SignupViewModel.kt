package com.sigmai.stylemento.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor() : ViewModel() {
    val nextEvent = SingleLiveEvent<Any>()
    val previousEvent = SingleLiveEvent<Any>()

    val email = MutableLiveData<String>()
    val authenticationCode = MutableLiveData<String>()
    val id = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val passwordConfirm = MutableLiveData<String>()

    fun onPrevious() {
        previousEvent.call()
    }

    fun onNext() {
        nextEvent.call()
    }
}