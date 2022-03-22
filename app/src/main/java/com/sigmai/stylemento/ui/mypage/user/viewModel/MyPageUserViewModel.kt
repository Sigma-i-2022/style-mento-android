package com.sigmai.stylemento.ui.mypage.user.viewModel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.data.model.response.myPage.MyPageClient
import com.sigmai.stylemento.data.repository.myPage.MyPageRepositoryImpl
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.usecase.user.GetUserUseCase
import com.sigmai.stylemento.global.store.AuthenticationInformation
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class MyPageUserViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var myPageRepository: MyPageRepositoryImpl

    val user = MutableLiveData<MyPageClient>()

    fun onRevisionClick(view: View) {
        view.findNavController().navigate(R.id.action_main_to_user_revision)
    }

    fun getUserInfo() {
        viewModelScope.launch {
            val receivedUser = withContext(Dispatchers.IO) {
                myPageRepository.getMyPageClient(AuthenticationInformation.email.value!!)
            }
            user.value = receivedUser
        }
    }
}