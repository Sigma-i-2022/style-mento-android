package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.data.model.CoordinatorResponse

interface CoordinatorRepository {
    fun getCoordinatorInfo() : Coordinator
    suspend fun getCoordinatorList() : List<CoordinatorResponse>
}