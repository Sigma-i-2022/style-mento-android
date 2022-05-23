package com.sigmai.stylemento.ui.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.domain.usecase.signup.LoginUseCase
import com.sigmai.stylemento.firebase.SmFirebaseMessagingService
import com.sigmai.stylemento.global.store.AuthenticationInfo
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var loginUserCase: LoginUseCase

    val startNext = SingleLiveEvent<Any>()
    val finishEvent = SingleLiveEvent<Any>()

    val email = MutableLiveData("")
    val password = MutableLiveData("")

    fun onClickSignUp() {
        startNext.call()
    }

    fun onLogin(view: View) {
        viewModelScope.launch {
            val isSuccessful = loginUserCase(email.value!!, password.value!!, SmFirebaseMessagingService.getToken(view.context))
            //if(isSuccessful) finishEvent.call()
            AuthenticationInfo.email.value = email.value!!
            AuthenticationInfo.userType = AuthenticationInfo.TYPE_COORDINATOR

            // if(isSuccessful) TODO : 배포할 때는 아래 조건문을 지우고 이 조건문을 사용하세요.
            if(true) finishEvent.call()
        }
    }
}