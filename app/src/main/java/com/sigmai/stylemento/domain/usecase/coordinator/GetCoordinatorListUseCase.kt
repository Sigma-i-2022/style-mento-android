package com.sigmai.stylemento.domain.usecase.coordinator

import com.sigmai.stylemento.data.repository.work.WorkRepositoryImpl
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.global.store.AuthenticationInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCoordinatorListUseCase @Inject constructor(val repository: WorkRepositoryImpl) {
    suspend operator fun invoke() : List<Coordinator> {
        return withContext(Dispatchers.IO) {
            repository.getCrdiList(AuthenticationInfo.email.value!!).map { Coordinator.from(it) }
        }
    }
}