package com.sigmai.stylemento.domain.usecase

import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.domain.repository.CoordinatorUserRepository

class GetCoordinatorUserUseCase(private val coordinatorUserRepository: CoordinatorUserRepository) {
    suspend operator fun invoke() : Coordinator {
        return Coordinator.from(coordinatorUserRepository.getUserInfo())
    }
}