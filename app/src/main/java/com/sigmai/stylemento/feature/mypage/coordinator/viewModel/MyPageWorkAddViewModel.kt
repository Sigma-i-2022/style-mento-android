package com.sigmai.stylemento.feature.mypage.coordinator.viewModel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.usecase.UserUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageWorkAddViewModel : ViewModel() {
    private val _coordinator = MutableLiveData<Coordinator>()

    val coordinator: LiveData<Coordinator> get() = _coordinator

    val startBack = SingleLiveEvent<Any>()
    val startSave = SingleLiveEvent<Any>()
    val startTagAddition = SingleLiveEvent<Any>()

    fun onBackClick() {
        startBack.call()
    }
    fun onSaveClick() {
        startSave.call()
    }
    fun onTagAdditionClick() {
        startTagAddition.call()
    }

    fun getCoordinatorInfo() {
        _coordinator.postValue(Client.getCoordinatorInfo())
    }
}