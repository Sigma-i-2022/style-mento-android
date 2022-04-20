package com.sigmai.stylemento.ui.reservation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.data.repository.reservation.ReservationRepositoryImpl
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

    private val receipts = MutableLiveData<List<Common>>(listOf())
    val email = MutableLiveData<String>("")
    val startBack = SingleLiveEvent<Any>()
    val startInfo = SingleLiveEvent<Any>()

    fun requestReceipts(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                receipts.value = reservationRepository.getReservationCommonList(email.value!!, 1, 10)
            }
        }
    }
    fun requestEmail(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){

            }
        }
    }
    fun onBackClick(){
        startBack.call()
    }
    fun onInfoClick(){
        startInfo.call()
    }
}