package com.sigmai.stylemento.ui.coordinator

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.domain.entity.TempCoordinator
import com.sigmai.stylemento.domain.usecase.GetCoordinatorListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoordinatorViewModel : ViewModel() {
    val dummyList = mutableListOf<TempCoordinator>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val getCoordinatorListUseCase = GetCoordinatorListUseCase()
            dummyList.clear()
            dummyList.addAll(getCoordinatorListUseCase())
        }
    }
}