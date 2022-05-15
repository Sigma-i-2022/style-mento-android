package com.sigmai.stylemento.ui.mypage.client.revision

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.data.model.response.myPage.MyPageClient
import com.sigmai.stylemento.data.repository.image.ImageRepositoryImpl
import com.sigmai.stylemento.data.repository.myPage.MyPageRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.*
import javax.inject.Inject

@HiltViewModel
class MyPageRevisionViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var myPageRepository: MyPageRepositoryImpl
    @Inject
    lateinit var imageRepository: ImageRepositoryImpl

    val user = MutableLiveData<MyPageClient>()
    val introduction = MutableLiveData("")
    var uuid = "";

    fun getUserInfo() {
        viewModelScope.launch {
            val receivedUser = withContext(Dispatchers.IO) {
                myPageRepository.getMyPageClient(AuthenticationInfo.email.value!!)
            }
            user.value = receivedUser
            introduction.value = user.value!!.intro
        }
    }

    fun onBack(view: View) {
        view.findNavController().navigateUp()
    }

    fun onSave(view: View) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                myPageRepository.putMyPageClient(
                    AuthenticationInfo.email.value!!,
                    user.value!!.userId,
                    introduction.value!!
                )
            }
            view.findNavController().navigateUp()
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