package com.sigmai.stylemento.ui.coordinator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.repository.datasource.DummyCoordinatorDataSource
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.domain.usecase.coordinator.GetCoordinatorUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent

class CoordinatorPageViewModel : ViewModel() {
    private val _coordinator = MutableLiveData<Coordinator>()

    val coordinator: LiveData<Coordinator> get() = _coordinator

    val startBack = SingleLiveEvent<Any>()
    val startInstruction = SingleLiveEvent<Any>()
    val startWork = SingleLiveEvent<Any>()
    val startReview = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
    fun onInstructionClick(){
        startInstruction.call()
    }
    fun onWorkClick(){
        startWork.call()
    }
    fun onReviewClick(){
        startReview.call()
    }

    fun getCoordinatorInfo(position : Int) {
        _coordinator.postValue(Coordinator.from(DummyCoordinatorDataSource().getCoordinatorList()[position]))
    }
}