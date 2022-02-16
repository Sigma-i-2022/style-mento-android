package com.sigmai.stylemento.domain.usecase.coordinator

import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.data.repository.CoordinatorRepository
import com.sigmai.stylemento.data.repository.UserRepository

class GetCoordinatorUseCase(val coordinatorRepository: CoordinatorRepository) {
    operator fun invoke() : Coordinator {
        return coordinatorRepository.getCoordinatorInfo()
    }
}