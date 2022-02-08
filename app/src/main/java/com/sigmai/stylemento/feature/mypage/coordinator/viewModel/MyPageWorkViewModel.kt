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

class MyPageWorkViewModel : ViewModel() {
    private val _coordinator = MutableLiveData<Coordinator>()

    val coordinator: LiveData<Coordinator> get() = _coordinator

    val startAddition = SingleLiveEvent<Any>()

    fun onAdditionClick() {
        startAddition.call()
    }

    fun getCoordinatorInfo() {
        _coordinator.postValue(Client.getCoordinatorInfo())
    }
}