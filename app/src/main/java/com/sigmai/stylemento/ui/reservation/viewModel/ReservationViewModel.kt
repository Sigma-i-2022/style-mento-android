package com.sigmai.stylemento.ui.reservation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Receipt
import com.sigmai.stylemento.data.repository.datasource.DummyCoordinatorDataSource
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.global.util.SingleLiveEvent

class ReservationViewModel : ViewModel() {
    private val _coordinator = MutableLiveData<Coordinator>()
    private val _receipt = MutableLiveData<Receipt>()

    val coordinator: LiveData<Coordinator> get() = _coordinator
    val receipt: LiveData<Receipt> get() = _receipt
    private val timeCheck = Array(28){false}

    fun getCoordinatorInfo(position : Int) {
        _coordinator.postValue(Coordinator.from(DummyCoordinatorDataSource().getCoordinatorList()[position]))
    }
    fun setReceipt(item : Receipt){
        _receipt.postValue(item)
    }
    fun toggleTimeCheck(position: Int){
        timeCheck[position] = !timeCheck[position]
    }
    val startBack = SingleLiveEvent<Any>()
    val startNext = SingleLiveEvent<Any>()

    val startFeedback = SingleLiveEvent<Any>()
    val startRecommend = SingleLiveEvent<Any>()
    val startChatting = SingleLiveEvent<Any>()
    val startFaceToFace = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
    fun onNextClick(){
        startNext.call()
    }
    fun onFeedbackClick(){
        startFeedback.call()
    }
    fun onRecommendClick(){
        startRecommend.call()
    }
    fun onChattingClick(){
        startChatting.call()
    }
    fun onFaceToFaceClick(){
        startFaceToFace.call()
    }
}