package com.sigmai.stylemento.ui.mypage.client.revision

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.data.model.response.myPage.MyPageClient
import com.sigmai.stylemento.data.repository.myPage.MyPageRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInformation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class MyPageRevisionViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var myPageRepository: MyPageRepositoryImpl

    val user = MutableLiveData<MyPageClient>()
    val introduction = MutableLiveData("")

    fun getUserInfo() {
        viewModelScope.launch {
            val receivedUser = withContext(Dispatchers.IO) {
                myPageRepository.getMyPageClient(AuthenticationInformation.email.value!!)
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
                myPageRepository.putMyPageClient(AuthenticationInformation.email.value!!, user.value!!.userId, introduction.value!!)
            }
            view.findNavController().navigateUp()
        }
    }

    fun uploadImage(file: MultipartBody.Part) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                myPageRepository.postMyPageImage(AuthenticationInformation.email.value!!, file)
            }
        }
    }
}