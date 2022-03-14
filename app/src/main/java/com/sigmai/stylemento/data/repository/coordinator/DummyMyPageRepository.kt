package com.sigmai.stylemento.data.repository.coordinator

import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.data.model.CoordinatorResponse
import com.sigmai.stylemento.data.repository.datasource.DummyCoordinatorDataSource
import com.sigmai.stylemento.data.repository.datasource.DummyMyPageDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DummyMyPageRepository {
    private val dataSource = DummyMyPageDataSource()

    suspend fun getUserInfo(): CoordinatorResponse {
        return withContext(Dispatchers.IO) {
            dataSource.getUserInfo()
        }
    }

    suspend fun deletePiece(id: Long) : Boolean {
        return withContext(Dispatchers.IO) {
            dataSource.deletePiece(id)
            true
        }
    }
}