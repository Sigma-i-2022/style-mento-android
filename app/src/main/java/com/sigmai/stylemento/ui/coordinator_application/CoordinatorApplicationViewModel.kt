package com.sigmai.stylemento.ui.coordinator_application

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.sigmai.stylemento.R

class CoordinatorApplicationViewModel : ViewModel() {
    fun onClickApplying(view: View) {
        val navController = view.findNavController()
        navController.navigate(R.id.action_application_to_application_viewpager)
    }
}