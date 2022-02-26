package com.sigmai.stylemento.ui.coordinator

import androidx.lifecycle.ViewModel
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
}