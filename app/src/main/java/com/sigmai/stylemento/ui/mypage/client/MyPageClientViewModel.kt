package com.sigmai.stylemento.ui.mypage.client

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.data.model.response.myPage.MyPageClient
import com.sigmai.stylemento.data.repository.lookBook.LookBookRepositoryImpl
import com.sigmai.stylemento.data.repository.myPage.MyPageRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInformation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MyPageClientViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var myPageRepository: MyPageRepositoryImpl
    @Inject
    lateinit var lookBookRepository: LookBookRepositoryImpl

    val user = MutableLiveData<MyPageClient>()
    val isIntroductionExtended = MutableLiveData(false)
    val isMyPage = MutableLiveData(true)

    val lookPageList = MutableLiveData<List<LookPage>>()

    fun onRevisionClick(view: View) {
        view.findNavController().navigate(R.id.action_main_to_user_revision)
    }

    fun getUserInfo() {
        viewModelScope.launch {
            val receivedUser = withContext(Dispatchers.IO) {
                myPageRepository.getMyPageClient(AuthenticationInformation.email.value!!)
            }
            user.value = receivedUser

            val lookBooks = withContext(Dispatchers.IO) {
                lookBookRepository.getLookPageAll(AuthenticationInformation.email.value!!, 0)
            }
            lookPageList.value = lookBooks
        }

    }

    fun onExtend() {
        isIntroductionExtended.value = !isIntroductionExtended.value!!
    }

    fun onAdd(view: View) {
        view.findNavController().navigate(R.id.action_main_to_add_piece)
    }
}