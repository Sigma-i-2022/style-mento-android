package com.sigmai.stylemento.domain.usecase.user

import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.domain.repository.CoordinatorUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeletePieceUseCase(private val coordinatorUserRepository: CoordinatorUserRepository) {
    suspend operator fun invoke(id: Long) {
        withContext(Dispatchers.IO) {
            coordinatorUserRepository.deletePiece(id)
        }
    }
}