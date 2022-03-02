package com.sigmai.stylemento.ui.coordinator_application

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.global.util.SingleLiveEvent

class ApplicationViewPagerViewModel : ViewModel() {
    val moveNextPageEvent = SingleLiveEvent<Any>()

    fun onClickNext() {
        moveNextPageEvent.call()
    }

    fun onClickComplete(view: View) {
        val navController = view.findNavController()
        navController.navigate(R.id.action_application_viewpager_to_application_finish)
    }
}