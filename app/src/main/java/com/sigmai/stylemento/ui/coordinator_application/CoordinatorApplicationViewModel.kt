package com.sigmai.stylemento.ui.coordinator_application

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.global.util.SingleLiveEvent

class CoordinatorApplicationViewModel : ViewModel() {
    val finishEvent = SingleLiveEvent<Any>()

    fun onClickApplying(view: View) {
        val navController = view.findNavController()
        navController.navigate(R.id.action_application_to_application_viewpager)
    }

    fun onFinish() {
        finishEvent.call()
    }
}