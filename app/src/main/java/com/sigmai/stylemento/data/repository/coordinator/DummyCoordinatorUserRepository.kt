package com.sigmai.stylemento.data.repository.coordinator

import com.sigmai.stylemento.data.model.CoordinatorResponse
import com.sigmai.stylemento.data.repository.datasource.DummyCoordinatorUserDataSource
import com.sigmai.stylemento.domain.repository.CoordinatorUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DummyCoordinatorUserRepository : CoordinatorUserRepository {
    private val dataSource = DummyCoordinatorUserDataSource()

    override suspend fun getUserInfo(): CoordinatorResponse {
        return withContext(Dispatchers.IO) {
            dataSource.getUserInfo()
        }
    }

    override suspend fun deletePiece(id: Long) : Boolean {
        return withContext(Dispatchers.IO) {
            dataSource.deletePiece(id)
            true
        }
    }
}