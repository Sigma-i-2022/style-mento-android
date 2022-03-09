package com.sigmai.stylemento.ui.coordinator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.repository.datasource.DummyCoordinatorDataSource
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.global.util.SingleLiveEvent

class CoordinatorPageViewModel : ViewModel() {
    private val _coordinator = MutableLiveData<Coordinator>()
    val coordinator: LiveData<Coordinator> get() = _coordinator
    val isExtended = MutableLiveData(false)

    val startBack = SingleLiveEvent<Any>()
    val startChat = SingleLiveEvent<Any>()
    val startReserve = SingleLiveEvent<Any>()

    fun onBack(){
        startBack.call()
    }
    fun onClickInstruction(){
        isExtended.value = !(isExtended.value!!)
    }
    fun onChatClick(){
        startChat.call()
    }
    fun onReserveClick(){
        startReserve.call()
    }

    fun getCoordinatorInfo(position : Int) {
        _coordinator.postValue(Coordinator.from(DummyCoordinatorDataSource().getCoordinatorList()[position]))
    }
}