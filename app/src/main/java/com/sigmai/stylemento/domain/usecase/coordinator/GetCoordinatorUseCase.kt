package com.sigmai.stylemento.domain.usecase.coordinator

import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.domain.repository.CoordinatorRepository

class GetCoordinatorUseCase(val coordinatorRepository: CoordinatorRepository) {
    operator fun invoke() : Coordinator {
        return coordinatorRepository.getCoordinatorInfo()
    }
}