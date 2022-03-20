package com.sigmai.stylemento.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.domain.usecase.signup.AuthenticateUseCase
import com.sigmai.stylemento.domain.usecase.signup.SendAuthenticationCodeUseCase
import com.sigmai.stylemento.domain.usecase.signup.SignUpUseCase
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
    @Inject
    lateinit var signupUseCase: SignUpUseCase

    val nextEvent = SingleLiveEvent<Any>()
    val previousEvent = SingleLiveEvent<Any>()

    val email = MutableLiveData("")
    val authenticationCode = MutableLiveData("")
    val id = MutableLiveData("")
    val password = MutableLiveData("")
    val passwordConfirm = MutableLiveData("")
    val isButtonClickable = MutableLiveData<Boolean>()
    val currentPage = MutableLiveData<Int>()

    fun onPrevious() {
        previousEvent.call()
    }

    fun onNext() {
        if(currentPage.value == 4) {
            signup()
        }
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

    fun signup() {
        viewModelScope.launch {
            signupUseCase(id.value!!, email.value!!, password.value!!, passwordConfirm.value!!)
        }
    }
}