package com.sigmai.stylemento.data.repository.coordinator

import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.data.model.CoordinatorResponse
import com.sigmai.stylemento.data.repository.datasource.DummyCoordinatorDataSource
import com.sigmai.stylemento.domain.repository.CoordinatorRepository
import javax.inject.Inject

class DummyCoordinatorRepository
@Inject constructor() : CoordinatorRepository {
    private val dataSource = DummyCoordinatorDataSource()

    override fun getCoordinatorInfo(): Coordinator {
        return Client.getCoordinatorInfo()
    }

    override suspend fun getCoordinatorList(): List<CoordinatorResponse> {
        return dataSource.getCoordinatorList()
    }
}