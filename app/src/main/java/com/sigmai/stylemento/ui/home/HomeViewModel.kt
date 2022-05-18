package com.sigmai.stylemento.ui.home

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.global.util.SingleLiveEvent

class HomeViewModel : ViewModel() {
    val startNotification = SingleLiveEvent<Any>()
    val startCheckReservation = SingleLiveEvent<Any>()
    val startPrivacy = SingleLiveEvent<Any>()

    fun startNotificationFragment() {
        startNotification.call()
    }
    fun startCheckReservationFragment() {
        startCheckReservation.call()
    }
    fun startPrivacyDialog(){
        startPrivacy.call()
    }

    fun onClickApplyCoordinator(view: View) {
        val navController = view.findNavController()
        navController.navigate(R.id.action_main_to_application)
    }
}