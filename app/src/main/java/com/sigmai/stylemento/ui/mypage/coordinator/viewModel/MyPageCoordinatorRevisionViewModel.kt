package com.sigmai.stylemento.ui.mypage.coordinator.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.data.model.response.myPage.MyPageCrdi
import com.sigmai.stylemento.data.repository.myPage.MyPageRepositoryImpl
import com.sigmai.stylemento.data.repository.user.UserRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInformation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MyPageCoordinatorRevisionViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var myPageRepository: MyPageRepositoryImpl

    val userInfo = MutableLiveData<MyPageCrdi>()
    val introduction = MutableLiveData("")

    fun loadData() {
        viewModelScope.launch {
            val user = withContext(Dispatchers.IO) {
                myPageRepository.getMyPageCrdi(AuthenticationInformation.email.value!!)
            }
            userInfo.value = user
            introduction.value = user.intro
        }
    }

    fun onSave(view: View) {
        updateProfile()
        view.findNavController().navigateUp()
    }

    fun updateProfile() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                myPageRepository.putMyPageCrdi(AuthenticationInformation.email.value!!, userInfo.value!!.userId, introduction.value!!)
            }
        }
    }
}