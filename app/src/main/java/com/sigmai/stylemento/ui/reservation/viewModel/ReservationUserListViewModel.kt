package com.sigmai.stylemento.ui.reservation.viewModel

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.global.util.SingleLiveEvent

class ReservationUserListViewModel : ViewModel() {
    val startBack = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
}