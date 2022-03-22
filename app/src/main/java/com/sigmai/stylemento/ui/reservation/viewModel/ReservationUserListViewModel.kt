package com.sigmai.stylemento.ui.reservation.viewModel

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.repository.reservation.ReservationRepositoryImpl
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReservationUserListViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var reservationRepository: ReservationRepositoryImpl

    val startBack = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
}