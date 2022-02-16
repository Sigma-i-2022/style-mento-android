package com.sigmai.stylemento.di

import com.sigmai.stylemento.data.repository.coordinator.CoordinatorRepository
import com.sigmai.stylemento.data.repository.coordinator.MemoryCoordinatorRepository
import com.sigmai.stylemento.data.repository.user.UserRepositoryImpl
import com.sigmai.stylemento.data.repository.user.UserRepository
import com.sigmai.stylemento.domain.usecase.coordinator.GetRecommendedCoordinatorListUseCase

object AppConfigs {
    val userRepository: UserRepository = UserRepositoryImpl()
    val coordinatorRepository: CoordinatorRepository = MemoryCoordinatorRepository()
    val getRecommendedCoordinatorListUseCase = GetRecommendedCoordinatorListUseCase()
}