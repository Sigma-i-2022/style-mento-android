package com.sigmai.stylemento.ui.coordinator

import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.domain.usecase.coordinator.GetCoordinatorListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoordinatorViewModel : ViewModel() {
    val getCoordinatorListUseCase: GetCoordinatorListUseCase = AppConfigs.getCoordinatorListUseCase
    val dummyList = mutableListOf<Coordinator>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            dummyList.clear()
            dummyList.addAll(getCoordinatorListUseCase())
        }
    }

    fun onClickCoordinatorProfile(view: View, position: Int) {
        val bundle = bundleOf("position" to position)
        val navController = view.findNavController()
        navController.navigate(R.id.action_main_to_coordinator_page, bundle)
    }
}