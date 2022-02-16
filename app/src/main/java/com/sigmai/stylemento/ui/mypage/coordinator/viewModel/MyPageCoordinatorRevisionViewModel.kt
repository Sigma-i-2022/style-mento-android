package com.sigmai.stylemento.ui.mypage.coordinator.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.usecase.coordinator.GetCoordinatorUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageCoordinatorRevisionViewModel : ViewModel() {
    private val _coordinator = MutableLiveData<Coordinator>()
    private val getCoordinatorUseCase: GetCoordinatorUseCase = GetCoordinatorUseCase(AppConfigs.coordinatorRepository)

    val coordinator: LiveData<Coordinator> get() = _coordinator

    val startBack = SingleLiveEvent<Any>()
    val startSave = SingleLiveEvent<Any>()
    val startTagAddition = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
    fun onSaveClick(){
        startSave.call()
    }
    fun onTagAdditionClick(){
        startTagAddition.call()
    }

    fun getCoordinatorInfo() {
        _coordinator.postValue(getCoordinatorUseCase())
    }
}