package com.sigmai.stylemento.ui.coordinator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.data.repository.coordinator.DummyCoordinatorRepository
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.global.util.SingleLiveEvent
import kotlinx.coroutines.launch

class CoordinatorPageViewModel : ViewModel() {
    val repository = DummyCoordinatorRepository()

    private val _coordinator = MutableLiveData<Coordinator>()
    val coordinator: LiveData<Coordinator> get() = _coordinator
    val isExtended = MutableLiveData(false)

    val startChat = SingleLiveEvent<Any>()
    val startReserve = SingleLiveEvent<Any>()

    fun onClickInstruction(){
        isExtended.value = !(isExtended.value!!)
    }
    fun onChatClick(){
        startChat.call()
    }
    fun onReserveClick(){
        startReserve.call()
    }

    fun loadCoordinatorInfo(position : Int) {
        viewModelScope.launch {
            _coordinator.postValue(Coordinator.from( repository.getCoordinatorList()[position]))
        }
    }
}