package com.sigmai.stylemento.feature.mypage.user.viewModel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.usecase.UserUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageLookbookItemViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    private val userUseCase: UserUseCase = UserUseCase(AppConfigs.userRepository)

    val user: LiveData<User> get() = _user

    val startBack = SingleLiveEvent<Any>()
    val startRevision = SingleLiveEvent<Any>()
    val startDelete = SingleLiveEvent<Any>()
    val startInstruction = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
    fun onRevisionClick(){
        startRevision.call()
    }
    fun onDeleteClick(){
        startDelete.call()
    }
    fun onInstructionClick(){
        startInstruction.call()
    }

    fun getUserInfo() {
        //_user.postValue(userUseCase.getUser())
        _user.postValue(Client.getUserInfo())
    }
}