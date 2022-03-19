package com.sigmai.stylemento.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.domain.usecase.signup.AuthenticateUseCase
import com.sigmai.stylemento.domain.usecase.signup.SendAuthenticationCodeUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var sendAuthenticationCodeUseCase: SendAuthenticationCodeUseCase
    @Inject
    lateinit var authenticateUseCase: AuthenticateUseCase

    val nextEvent = SingleLiveEvent<Any>()
    val previousEvent = SingleLiveEvent<Any>()

    val email = MutableLiveData<String>()
    val authenticationCode = MutableLiveData<String>()
    val id = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val passwordConfirm = MutableLiveData<String>()
    val isButtonClickable = MutableLiveData<Boolean>()

    fun onPrevious() {
        previousEvent.call()
    }

    fun onNext() {
        nextEvent.call()
    }

    fun sendAuthenticationCode() {
        viewModelScope.launch {
            sendAuthenticationCodeUseCase(email.value!!)
        }
    }

    fun authenticate() {
        viewModelScope.launch {
            val code = authenticationCode.value!!
            val email = email.value!!
            authenticateUseCase(code, email)
        }
    }
}