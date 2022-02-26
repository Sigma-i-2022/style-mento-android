package com.sigmai.stylemento.domain.usecase.coordinator

import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.domain.repository.CoordinatorRepository
import com.sigmai.stylemento.global.util.GlideUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCoordinatorListUseCase(val repository: CoordinatorRepository) {
    suspend operator fun invoke() : List<Coordinator> {
        return withContext(Dispatchers.IO) {
            repository.getCoordinatorList().map { Coordinator.from(it) }
        }
    }
}