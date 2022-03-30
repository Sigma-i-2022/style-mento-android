package com.sigmai.stylemento.di

import com.sigmai.stylemento.domain.repository.CoordinatorRepository
import com.sigmai.stylemento.data.repository.coordinator.DummyCoordinatorRepository
import com.sigmai.stylemento.data.repository.user.UserRepositoryImpl
import com.sigmai.stylemento.domain.repository.UserRepository
import com.sigmai.stylemento.domain.usecase.coordinator.GetCoordinatorListUseCase
import com.sigmai.stylemento.domain.usecase.coordinator.GetRecommendedCoordinatorListUseCase

object AppConfigs {
    val userRepository: UserRepository = UserRepositoryImpl()
    val coordinatorRepository: CoordinatorRepository = DummyCoordinatorRepository()

    val getRecommendedCoordinatorListUseCase = GetRecommendedCoordinatorListUseCase()
}