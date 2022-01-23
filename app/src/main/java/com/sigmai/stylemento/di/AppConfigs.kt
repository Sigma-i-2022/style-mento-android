package com.sigmai.stylemento.di

import com.sigmai.stylemento.data.repository.MemoryUserRepository
import com.sigmai.stylemento.data.repository.UserRepository
import com.sigmai.stylemento.domain.usecase.GetRecommendedCoordinatorListUseCase

object AppConfigs {
    val userRepository: UserRepository = MemoryUserRepository()
    val getRecommendedCoordinatorListUseCase = GetRecommendedCoordinatorListUseCase()
}