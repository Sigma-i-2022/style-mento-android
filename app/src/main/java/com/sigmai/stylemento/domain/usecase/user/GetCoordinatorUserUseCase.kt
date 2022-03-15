package com.sigmai.stylemento.domain.usecase.user

import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.domain.repository.CoordinatorUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCoordinatorUserUseCase(private val coordinatorUserRepository: CoordinatorUserRepository) {
    suspend operator fun invoke() : Coordinator {
        return withContext(Dispatchers.IO) {
            Coordinator.from(coordinatorUserRepository.getUserInfo())
        }
    }
}