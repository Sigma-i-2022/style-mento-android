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
class AccountRegisterViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var reservationRepository: CancelReservationRepositoryImpl

    val accountNumber = MutableLiveData<String>("")
    val owner = MutableLiveData<String>("")
    val bank = MutableLiveData<String>("")

    val startBack = SingleLiveEvent<Any>()
    val startNext = SingleLiveEvent<Any>()
    val startSetBank = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
    fun onNextClick(){
        startNext.call()
    }
    fun onSetBankClick(){
        startSetBank.call()
    }
}