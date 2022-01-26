package com.sigmai.stylemento.feature.coordinator

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.domain.entity.TempCoordinator
import com.sigmai.stylemento.domain.usecase.GetCoordinatorListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoordinatorViewModel : ViewModel() {
    var dummyList: List<TempCoordinator>? = null

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val getCoordinatorListUseCase = GetCoordinatorListUseCase()
            dummyList = getCoordinatorListUseCase()
        }
    }
}