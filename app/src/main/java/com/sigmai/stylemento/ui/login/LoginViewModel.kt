package com.sigmai.stylemento.ui.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.domain.usecase.signup.LoginUseCase
import com.sigmai.stylemento.firebase.SmFirebaseMessagingService
import com.sigmai.stylemento.global.store.AuthenticationInformation
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
            AuthenticationInformation.email.value = email.value!!
            finishEvent.call() // TODO : 현재 로그인 요청 200 이 안 떨어져서 서버쪽과 대화 중, 나중에 이 행을 지우고 윗 라인 주석을 해제하세요.
        }
    }
}