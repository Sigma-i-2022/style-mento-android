package com.sigmai.stylemento.ui.mypage.coordinator.revision

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.data.model.response.myPage.MyPageCrdi
import com.sigmai.stylemento.data.repository.image.ImageRepositoryImpl
import com.sigmai.stylemento.data.repository.myPage.MyPageRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class MyPageCoordinatorRevisionViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var myPageRepository: MyPageRepositoryImpl
    @Inject
    lateinit var imageRepository: ImageRepositoryImpl

    val userInfo = MutableLiveData<MyPageCrdi>()
    val introduction = MutableLiveData("")
    var uuid = ""

    fun loadData() {
        viewModelScope.launch {
            val user = withContext(Dispatchers.IO) {
                myPageRepository.getMyPageCrdi(AuthenticationInfo.email.value!!)
            }
            userInfo.value = user
            introduction.value = user.intro
        }
    }

    fun onSave(view: View) {
        updateProfile()
        view.findNavController().navigateUp()
    }

    private fun updateProfile() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                myPageRepository.putMyPageCrdi(AuthenticationInfo.email.value!!, userInfo.value!!.userId, introduction.value!!)
            }
        }
    }

    fun uploadImage(file: MultipartBody.Part) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                uuid = imageRepository.postImage(file)
                myPageRepository.postMyPageImage(AuthenticationInfo.email.value!!, uuid)
            }
        }
    }
}