package com.sigmai.stylemento.data.repository.coordinator

import com.sigmai.stylemento.data.model.Coordinator

interface CoordinatorRepository {
    fun getCoordinatorInfo() : Coordinator
}