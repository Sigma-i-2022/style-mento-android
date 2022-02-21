package com.sigmai.stylemento.di

import com.sigmai.stylemento.data.repository.coordinator.CoordinatorRepository
import com.sigmai.stylemento.data.repository.coordinator.MemoryCoordinatorRepository
import com.sigmai.stylemento.data.repository.user.UserRepositoryImpl
import com.sigmai.stylemento.data.repository.user.UserRepository
import com.sigmai.stylemento.domain.usecase.coordinator.GetRecommendedCoordinatorListUseCase
import com.sigmai.stylemento.ui.coordinator_application.ApplicationViewPagerViewModel

object AppConfigs {
    val userRepository: UserRepository = UserRepositoryImpl()
    val coordinatorRepository: CoordinatorRepository = MemoryCoordinatorRepository()
    val getRecommendedCoordinatorListUseCase = GetRecommendedCoordinatorListUseCase()

    val applicationViewPagerViewModel = ApplicationViewPagerViewModel()
}