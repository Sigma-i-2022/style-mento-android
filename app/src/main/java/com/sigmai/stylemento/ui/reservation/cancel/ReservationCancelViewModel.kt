package com.sigmai.stylemento.ui.reservation.cancel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.data.model.response.myPage.MyPageCrdi
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.data.repository.cancelReservation.CancelReservationRepositoryImpl
import com.sigmai.stylemento.data.repository.myPage.MyPageRepositoryImpl
import com.sigmai.stylemento.data.repository.reservation.ReservationRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInformation
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
    @Inject
    lateinit var myPageRepository: MyPageRepositoryImpl

    val coordinator = MutableLiveData<MyPageCrdi>()
    fun requestCrdiInfo(email : String) {
        viewModelScope.launch {
            val coordi = withContext(Dispatchers.IO) {
                myPageRepository.getMyPageCrdi(email)
            }
            coordinator.value = coordi
        }
    }

    val common = MutableLiveData<Common>()
    fun requestCommon(seq : Long){
        viewModelScope.launch {
            val ack = withContext(Dispatchers.IO){
                reservationRepository.getReservationCommon(seq)
            }
            common.value = ack
        }
    }
    val email = MutableLiveData<String>("")
    val content = MutableLiveData<String>("")

    fun requestCancel(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                //cancelRepository.postCancelPayment(coordinator.value!!.seq, common.value!!.seq)
            }
        }
    }
    fun postReservationCommonHide(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                reservationRepository.postReservationCommonHide(AuthenticationInformation.email.value!!, common.value!!.seq)
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