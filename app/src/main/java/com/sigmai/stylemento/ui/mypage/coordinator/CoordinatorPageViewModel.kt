package com.sigmai.stylemento.ui.mypage.coordinator

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.data.model.response.myPage.MyPageCrdi
import com.sigmai.stylemento.data.repository.myPage.MyPageRepositoryImpl
import com.sigmai.stylemento.data.repository.work.WorkRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInformation
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CoordinatorPageViewModel
@Inject constructor() : ViewModel() {
    @Inject
    lateinit var workRepository: WorkRepositoryImpl
    @Inject
    lateinit var myPageRepository: MyPageRepositoryImpl

    val coordinator = MutableLiveData<MyPageCrdi>()
    val pieceList = MutableLiveData<List<LookPage>>()

    val isMyPage = MutableLiveData(false)
    val isExtended = MutableLiveData(false)

    val startChat = SingleLiveEvent<Any>()
    val startReserve = SingleLiveEvent<Any>()
    val onEditEvent = SingleLiveEvent<Any>()

    fun loadData() {
        loadCoordinatorInfo()

        viewModelScope.launch {
            val list = withContext(Dispatchers.IO) {
                workRepository.getCrdiWorkAll(AuthenticationInformation.email.value!!)
            }
            pieceList.value = list.map {
                it.toLookPage()
            }
        }
    }

    fun onClickInstruction() {
        isExtended.value = !(isExtended.value!!)
    }

    fun onChatClick() {
        startChat.call()
    }

    fun onReserveClick() {
        startReserve.call()
    }

    fun loadCoordinatorInfo() {
        viewModelScope.launch {
            val coordi = withContext(Dispatchers.IO) {
                myPageRepository.getMyPageCrdi(AuthenticationInformation.email.value!!)
            }
            coordinator.value = coordi
        }
    }

    fun deletePiece(id: Long) {
    }

    fun onEditPiece(view: View, id: Long) {
        onEditEvent.call()
//        val bundle = bundleOf("id" to id)
//        val navController = view.findNavController()
//        navController.navigate(R.id.action_coordinator_page_piece_scroll_to_add_piece, bundle)
    }
}