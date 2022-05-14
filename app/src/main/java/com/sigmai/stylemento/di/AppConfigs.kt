package com.sigmai.stylemento.di

import com.sigmai.stylemento.data.repository.user.DummyUserRepositoryImpl
import com.sigmai.stylemento.domain.repository.UserRepository
import com.sigmai.stylemento.domain.usecase.coordinator.GetRecommendedCoordinatorListUseCase

object AppConfigs {
    val userRepository: UserRepository = DummyUserRepositoryImpl()
}