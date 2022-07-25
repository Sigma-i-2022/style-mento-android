package com.sigmai.stylemento.ui.reservation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.data.repository.reservation.ReservationRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInfo
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ReservationListViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var reservationRepository: ReservationRepositoryImpl

    val commons = MutableLiveData<List<Common>>(listOf())
    val email = MutableLiveData<String>("")
    val startBack = SingleLiveEvent<Any>()
    val startInfo = SingleLiveEvent<Any>()
    val startAdapter = SingleLiveEvent<Any>()

    fun requestCommons(){
        viewModelScope.launch {
            val _commons = withContext(Dispatchers.IO){
                reservationRepository.getReservationCommonList(AuthenticationInfo.email.value!!, 0, 50)
            }
            commons.value = _commons
            startAdapter.call()
        }
    }
    fun postReservationClientPay(memberEmail: String, reservationSeq: Long){
        viewModelScope.launch {
            var ack = withContext(Dispatchers.IO){
                reservationRepository.postReservationClientPay(memberEmail, reservationSeq)
            }
        }
    }

    fun onBackClick(){
        startBack.call()
    }
    fun onInfoClick(){
        startInfo.call()
    }
    fun updateAdapter(){
        requestCommons()
    }
}