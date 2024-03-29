package com.sigmai.stylemento.ui.mypage.coordinator.revision

import android.view.View
import androidx.compose.runtime.MutableState
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
import kotlinx.coroutines.flow.MutableStateFlow
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
    var uuid: String? = null
    val isSeller = MutableStateFlow(false)

    fun loadData() {
        viewModelScope.launch {
            val user = withContext(Dispatchers.IO) {
                myPageRepository.getMyPageCrdi(AuthenticationInfo.email.value!!)
            }
            userInfo.value = user
            isSeller.value = user.expertYN == "Y"
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
                val expert = if(isSeller.value) "Y" else "N"
                myPageRepository.postMyPageCrdi(AuthenticationInfo.email.value!!, userInfo.value!!.userId, introduction.value!!, expert, uuid)
            }
        }
    }

    fun uploadImage(file: MultipartBody.Part) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                uuid = imageRepository.postImage(file)
                myPageRepository.postMyPageImage(AuthenticationInfo.email.value!!, uuid!!)
            }
        }
    }

    fun onSellerButtonClick(seller: Boolean) {
        isSeller.value = seller
    }
}