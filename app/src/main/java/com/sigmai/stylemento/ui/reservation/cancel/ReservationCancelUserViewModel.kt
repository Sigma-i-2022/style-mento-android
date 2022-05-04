package com.sigmai.stylemento.ui.reservation.cancel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.data.model.response.myPage.MyPageClient
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
class ReservationCancelUserViewModel @Inject constructor(): ViewModel() {
    @Inject
    lateinit var cancelRepository: CancelReservationRepositoryImpl
    @Inject
    lateinit var reservationRepository: ReservationRepositoryImpl
    @Inject
    lateinit var myPageRepository: MyPageRepositoryImpl

    val client = MutableLiveData<MyPageClient>()
    fun requestUserInfo(email : String) {
        viewModelScope.launch {
            val _client = withContext(Dispatchers.IO) {
                myPageRepository.getMyPageClient(email)
            }
            client.value = _client
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
    val content = MutableLiveData<String>("")
    val email = MutableLiveData<String>("")
    val seq = MutableLiveData<Long>(0)

    fun requestCancel(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                //reservationRepository.postReservationCommonHide(email.value!!, seq.value!!)
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