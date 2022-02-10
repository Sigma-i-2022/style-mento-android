package com.sigmai.stylemento.ui.mypage.coordinator.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.Coordinator
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