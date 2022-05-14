package com.sigmai.stylemento.ui.home

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.RecommendedCoordinator
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.usecase.user.GetUserUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    private val getUserUseCase: GetUserUseCase = GetUserUseCase(AppConfigs.userRepository)

    val user: LiveData<User> get() = _user
    val startNotification = SingleLiveEvent<Any>()
    val startCheckReservation = SingleLiveEvent<Any>()
    val startPrivacy = SingleLiveEvent<Any>()

    fun startNotificationFragment() {
        startNotification.call()
    }
    fun startCheckReservationFragment() {
        startCheckReservation.call()
    }
    fun startPrivacyDialog(){
        startPrivacy.call()
    }
    fun getUserInfo() {
        _user.postValue(getUserUseCase())
    }

    fun onClickApplyCoordinator(view: View) {
        val navController = view.findNavController()
        navController.navigate(R.id.action_main_to_application)
    }
}