package com.sigmai.stylemento.ui.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.BuildConfig.IS_PROD
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
            val res = loginUserCase(email.value!!, password.value!!, SmFirebaseMessagingService.getToken(view.context))

            AuthenticationInfo.email.value = email.value!!
            AuthenticationInfo.userType = res ?: return@launch

            finishEvent.call()
        }
    }
}