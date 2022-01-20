package com.sigmai.stylemento.feature.coordinator

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Coordinator

class CoordinatorViewModel : ViewModel() {
    val dummyList = listOf(
        Coordinator("11111"),
        Coordinator("122"),
        Coordinator("3333"),
        Coordinator("44444"),
        Coordinator("55555")
    )
}