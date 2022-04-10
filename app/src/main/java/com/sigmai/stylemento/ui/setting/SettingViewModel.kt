package com.sigmai.stylemento.ui.setting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.data.repository.cancelReservation.CancelReservationRepositoryImpl
import com.sigmai.stylemento.data.repository.reservation.ReservationRepositoryImpl
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var reservationRepository: CancelReservationRepositoryImpl

    val startBack = SingleLiveEvent<Any>()
    val startInquireByKakao = SingleLiveEvent<Any>()
    val startReview = SingleLiveEvent<Any>()
    val startRegister = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
    fun onInquireByKakaoClick(){
        startInquireByKakao.call()
    }
    fun onReviewClick(){
        startReview.call()
    }
    fun onRegisterClick(){
        startRegister.call()
    }
}