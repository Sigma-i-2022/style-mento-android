package com.sigmai.stylemento.ui.reservation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.data.repository.reservation.ReservationRepositoryImpl
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ReservationCancelUserViewModel @Inject constructor(): ViewModel() {
    @Inject
    lateinit var reservationRepository: ReservationRepositoryImpl
    val content = MutableLiveData<String>("")

    val email = MutableLiveData<String>("")
    val seq = MutableLiveData<Long>(0)

    fun requestCancel(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                reservationRepository.postReservationCommonHide(email.value!!, seq.value!!)
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