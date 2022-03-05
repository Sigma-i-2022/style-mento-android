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

    fun getCoordinatorInfo(position: Int) {
        _coordinator.postValue(Coordinator.from(DummyCoordinatorDataSource().getCoordinatorList()[position]))
    }

    fun setReceipt(item: Receipt) {
        _receipt.postValue(item)
    }

    val startBack = SingleLiveEvent<Any>()
    val startNext = SingleLiveEvent<Any>()

    val startFeedback = SingleLiveEvent<Any>()
    val startRecommend = SingleLiveEvent<Any>()
    val startChatting = SingleLiveEvent<Any>()
    val startFaceToFace = SingleLiveEvent<Any>()

    private var _serviceType = MutableLiveData<Int>(-1)
    private var _serviceWay = MutableLiveData<Int>(-1)
    private var _requestText = MutableLiveData<String>("")

    val serviceType : LiveData<Int> get() = _serviceType
    val serviceWay : LiveData<Int> get() = _serviceWay
    val requestText : LiveData<String> get() = _requestText

    fun onBackClick() {
        startBack.call()
    }

    fun onNextClick() {
        startNext.call()
    }

    fun onFeedbackClick() {
        _serviceType.value = if (_serviceType.value == 0) -1 else 0
        startFeedback.call()
    }

    fun onRecommendClick() {
        _serviceType.value = if (_serviceType.value == 1) -1 else 1
        startRecommend.call()
    }

    fun onChattingClick() {
        _serviceWay.value = if (_serviceWay.value == 0) -1 else 0
        startChatting.call()
    }

    fun onFaceToFaceClick() {
        _serviceWay.value = if (_serviceWay.value == 1) -1 else 1
        startFaceToFace.call()
    }

    fun setRequestText(text : String){
        _requestText.value = text
    }
}