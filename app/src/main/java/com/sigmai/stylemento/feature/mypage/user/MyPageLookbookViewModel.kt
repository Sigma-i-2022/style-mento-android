package com.sigmai.stylemento.feature.mypage.user

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.usecase.UserUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageLookbookViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    private val userUseCase: UserUseCase = UserUseCase(AppConfigs.userRepository)

    val user: LiveData<User> get() = _user

    val startAddLookbook = SingleLiveEvent<Any>()

    fun onAddLookbookClick(){
        startAddLookbook.call()
    }

    fun getUserInfo() {
        //_user.postValue(userUseCase.getUser())
        _user.postValue(Client.getUserInfo())
    }
}