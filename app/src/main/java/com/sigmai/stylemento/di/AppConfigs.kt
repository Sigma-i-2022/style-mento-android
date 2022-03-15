package com.sigmai.stylemento.di

import com.sigmai.stylemento.domain.repository.CoordinatorRepository
import com.sigmai.stylemento.data.repository.coordinator.DummyCoordinatorRepository
import com.sigmai.stylemento.data.repository.coordinator.DummyCoordinatorUserRepository
import com.sigmai.stylemento.data.repository.user.UserRepositoryImpl
import com.sigmai.stylemento.domain.repository.CoordinatorUserRepository
import com.sigmai.stylemento.domain.repository.UserRepository
import com.sigmai.stylemento.domain.usecase.user.GetCoordinatorUserUseCase
import com.sigmai.stylemento.domain.usecase.coordinator.GetCoordinatorListUseCase
import com.sigmai.stylemento.domain.usecase.coordinator.GetRecommendedCoordinatorListUseCase
import com.sigmai.stylemento.domain.usecase.user.DeletePieceUseCase
import com.sigmai.stylemento.ui.coordinator_application.ApplicationViewPagerViewModel

object AppConfigs {
    val userRepository: UserRepository = UserRepositoryImpl()
    val coordinatorRepository: CoordinatorRepository = DummyCoordinatorRepository()
    val coordinatorUserRepository: CoordinatorUserRepository = DummyCoordinatorUserRepository()

    val getCoordinatorListUseCase: GetCoordinatorListUseCase = GetCoordinatorListUseCase(coordinatorRepository)
    val getRecommendedCoordinatorListUseCase = GetRecommendedCoordinatorListUseCase()
    val getCoordinatorUserUseCase = GetCoordinatorUserUseCase(coordinatorUserRepository)
    val deletePieceUseCase = DeletePieceUseCase(coordinatorUserRepository)

    val applicationViewPagerViewModel = ApplicationViewPagerViewModel()
}