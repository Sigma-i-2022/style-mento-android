package com.sigmai.stylemento.data.repository

import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.data.model.User

class MemoryCoordinatorRepository : CoordinatorRepository {
    override fun getCoordinatorInfo(): Coordinator {
        return Client.getCoordinatorInfo()
    }
}