package com.sigmai.stylemento.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.FavoriteCoordinator
import com.sigmai.stylemento.data.model.Notification
import com.sigmai.stylemento.data.model.RecommendedCoordinator
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.feature.home.adapter.RecommendedCoordinatorAdapter
import com.sigmai.stylemento.global.di.AppConfigs
import com.sigmai.stylemento.global.usecase.UserUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent

class HomeViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    private val userUseCase: UserUseCase = UserUseCase(AppConfigs.userRepository)
    val user: LiveData<User> get() = _user
    val startNotification = SingleLiveEvent<Any>()

    val list = listOf(
        RecommendedCoordinator("name1", "tag5"),
        RecommendedCoordinator("name2", "tag6"),
        RecommendedCoordinator("name9", "tag7"),
        RecommendedCoordinator("name4", "tag8")
    )

    val favoriteList = listOf(
        FavoriteCoordinator("1"),
        FavoriteCoordinator("1"),
        FavoriteCoordinator("1"),
        FavoriteCoordinator("1"),
        FavoriteCoordinator("1")
    )

    val dummyList = listOf(
        Notification("eqkfeq_te님이 나를 어쩌구했어요1"),
        Notification("eqkfeq_te님이 나를 어쩌구했어용2"),
        Notification("eqkfeq_te님이 나를 어쩌구했어요3"),
        Notification("eqkfeq_te님이 나를 어쩌구했어용4"),
        Notification("eqkfeq_te님이 나를 어쩌구했어요5"),
        Notification("eqkfeq_te님이 나를 어쩌구했어요6")
    )

    fun startNotificationFragment() {
        startNotification.call()
    }

    fun getUserInfo() {
        _user.postValue(userUseCase.getUser())
    }
}