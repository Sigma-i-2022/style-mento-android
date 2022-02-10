package com.sigmai.stylemento.ui.mypage.coordinator.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageCoordinatorViewModel : ViewModel() {
    private val _coordinator = MutableLiveData<Coordinator>()

    val coordinator: LiveData<Coordinator> get() = _coordinator

    val startRevision = SingleLiveEvent<Any>()
    val startInstruction = SingleLiveEvent<Any>()
    val startWork = SingleLiveEvent<Any>()
    val startReview = SingleLiveEvent<Any>()

    fun onRevisionClick(){
        startRevision.call()
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

    fun getCoordinatorInfo() {
        _coordinator.postValue(Client.getCoordinatorInfo())
    }
}