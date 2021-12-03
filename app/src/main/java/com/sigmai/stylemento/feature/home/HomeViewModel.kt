package com.sigmai.stylemento.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.global.di.AppConfigs
import com.sigmai.stylemento.global.usecase.UserUseCase

class HomeViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    private val userUseCase: UserUseCase = UserUseCase(AppConfigs.userRepository)

    fun getUserInfo() {
        _user.postValue(userUseCase.getUser())
    }
}