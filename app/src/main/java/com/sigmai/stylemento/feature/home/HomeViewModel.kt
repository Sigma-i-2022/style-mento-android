package com.sigmai.stylemento.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.FavoriteCoordinator
import com.sigmai.stylemento.data.model.RecommendedCoordinator
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.usecase.UserUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    private val userUseCase: UserUseCase = UserUseCase(AppConfigs.userRepository)
    private val getRecommendedCoordinatorListUseCase = AppConfigs.getRecommendedCoordinatorListUseCase

    val user: LiveData<User> get() = _user
    val startNotification = SingleLiveEvent<Any>()
    var recommendedCoordinatorList: List<RecommendedCoordinator>? = null

    init {
        CoroutineScope(Dispatchers.IO).launch {
            recommendedCoordinatorList = getRecommendedCoordinatorListUseCase()
        }
    }

    val favoriteList = listOf(
        FavoriteCoordinator("1"),
        FavoriteCoordinator("1"),
        FavoriteCoordinator("1"),
        FavoriteCoordinator("1"),
        FavoriteCoordinator("1")
    )

    fun startNotificationFragment() {
        startNotification.call()
    }

    fun getUserInfo() {
        _user.postValue(userUseCase.getUser())
    }
}