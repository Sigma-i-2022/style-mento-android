package com.sigmai.stylemento.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.global.di.AppConfigs
import com.sigmai.stylemento.global.usecase.UserUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent

class HomeViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    private val userUseCase: UserUseCase = UserUseCase(AppConfigs.userRepository)
    val user: LiveData<User> get() = _user
    val startNotification = SingleLiveEvent<Any>()

    fun startNotificationFragment() {
        startNotification.call()
    }

    fun getUserInfo() {
        _user.postValue(userUseCase.getUser())
    }
}