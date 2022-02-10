package com.sigmai.stylemento.ui.mypage.user.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.usecase.GetUserUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageUserRevisionViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    private val getUserUseCase: GetUserUseCase = GetUserUseCase(AppConfigs.userRepository)

    val user: LiveData<User> get() = _user

    val startBack = SingleLiveEvent<Any>()
    val startSave = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
    fun onSaveClick(){
        startSave.call()
    }

    fun getUserInfo() {
        //_user.postValue(userUseCase.getUser())
        _user.postValue(Client.getUserInfo())
    }
}