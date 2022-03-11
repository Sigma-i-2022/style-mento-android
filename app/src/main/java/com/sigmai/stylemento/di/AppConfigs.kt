package com.sigmai.stylemento.di

import com.sigmai.stylemento.domain.repository.CoordinatorRepository
import com.sigmai.stylemento.data.repository.coordinator.DummyCoordinatorRepository
import com.sigmai.stylemento.data.repository.datasource.DummyCoordinatorDataSource
import com.sigmai.stylemento.data.repository.user.DummyDataSource
import com.sigmai.stylemento.data.repository.user.UserRepositoryImpl
import com.sigmai.stylemento.data.repository.user.UserRepository
import com.sigmai.stylemento.domain.usecase.coordinator.GetCoordinatorListUseCase
import com.sigmai.stylemento.domain.usecase.coordinator.GetRecommendedCoordinatorListUseCase
import com.sigmai.stylemento.ui.coordinator_application.ApplicationViewPagerViewModel

object AppConfigs {
    val userRepository: UserRepository = UserRepositoryImpl()
    val coordinatorRepository: CoordinatorRepository = DummyCoordinatorRepository()
    val getCoordinatorListUseCase: GetCoordinatorListUseCase = GetCoordinatorListUseCase(coordinatorRepository)
    val getRecommendedCoordinatorListUseCase = GetRecommendedCoordinatorListUseCase()

    val applicationViewPagerViewModel = ApplicationViewPagerViewModel()
}