package com.sigmai.stylemento.data.repository.coordinator

import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.Coordinator

class MemoryCoordinatorRepository : CoordinatorRepository {
    override fun getCoordinatorInfo(): Coordinator {
        return Client.getCoordinatorInfo()
    }
}