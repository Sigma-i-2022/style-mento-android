package com.sigmai.stylemento.ui.mypage.user.viewModel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.usecase.user.GetUserUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageUserViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    private val getUserUseCase: GetUserUseCase = GetUserUseCase(AppConfigs.userRepository)

    val user: LiveData<User> get() = _user

    fun onRevisionClick(view: View) {
        view.findNavController().navigate(R.id.action_main_to_user_revision)
    }

    fun getUserInfo() {
        _user.postValue(getUserUseCase())
    }
}