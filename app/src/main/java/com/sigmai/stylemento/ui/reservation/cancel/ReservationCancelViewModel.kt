package com.sigmai.stylemento.ui.reservation.cancel

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
class ReservationCancelViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var cancelRepository: CancelReservationRepositoryImpl
    @Inject
    lateinit var reservationRepository: ReservationRepositoryImpl

    val email = MutableLiveData<String>("")
    val seq = MutableLiveData<Long>(0)
    val content = MutableLiveData<String>("")

    fun requestCancel(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                //cancelRepository.postCancelPayment(email.value!!, seq.value!!)
            }
        }
    }
    fun postReservationCommonHide(memberEmail: String, reservationSeq: Long){
        viewModelScope.launch {
            var ack = false
            withContext(Dispatchers.IO){
                ack = reservationRepository.postReservationCommonHide(memberEmail, reservationSeq)
            }
        }
    }
    val startBack = SingleLiveEvent<Any>()
    val startNext = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
    fun onNextClick(){
        startNext.call()
    }
}