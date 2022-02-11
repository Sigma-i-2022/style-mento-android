package com.sigmai.stylemento.ui.mypage.user.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.usecase.GetUserUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageUserViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    private val getUserUseCase: GetUserUseCase = GetUserUseCase(AppConfigs.userRepository)

    val user: LiveData<User> get() = _user

    val startRevision = SingleLiveEvent<Any>()
    val startInstruction = SingleLiveEvent<Any>()

    fun onRevisionClick(){
        startRevision.call()
    }
    fun onInstructionClick(){
        startInstruction.call()
    }

    fun getUserInfo() {
        _user.postValue(getUserUseCase())
    }
}