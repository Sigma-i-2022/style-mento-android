package com.sigmai.stylemento.di

import com.sigmai.stylemento.data.repository.CoordinatorRepository
import com.sigmai.stylemento.data.repository.MemoryCoordinatorRepository
import com.sigmai.stylemento.data.repository.MemoryUserRepository
import com.sigmai.stylemento.data.repository.UserRepository
import com.sigmai.stylemento.domain.usecase.coordinator.GetRecommendedCoordinatorListUseCase

object AppConfigs {
    val userRepository: UserRepository = MemoryUserRepository()
    val coordinatorRepository: CoordinatorRepository = MemoryCoordinatorRepository()
    val getRecommendedCoordinatorListUseCase = GetRecommendedCoordinatorListUseCase()
}