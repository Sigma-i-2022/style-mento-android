package com.sigmai.stylemento.ui.mypage.coordinator.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.data.api.ClientLookBookService
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.data.model.response.myPage.MyPageClient
import com.sigmai.stylemento.data.repository.lookBook.LookBookRepositoryImpl
import com.sigmai.stylemento.data.repository.myPage.MyPageRepositoryImpl
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.global.store.AuthenticationInformation
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class AddPieceViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var myPageRepository: MyPageRepositoryImpl

    @Inject
    lateinit var lookbookRepository: LookBookRepositoryImpl

    val lookPage = MutableLiveData<LookPage>()

    val onFinishEvent = SingleLiveEvent<Any>()

    val imageUrl = MutableLiveData("")
    val description = MutableLiveData("")
    val top = MutableLiveData("")
    val bottom = MutableLiveData("")
    val shoes = MutableLiveData("")
    val tagList = MutableLiveData<List<String>>(listOf())
    val isNewPage = MutableLiveData(true)

    fun loadPiece(id: Long) {
        if(id < 0) {
            return
        }
        isNewPage.value = false

        viewModelScope.launch {
            val piece = withContext(Dispatchers.IO) {
                lookbookRepository.getLookPage(id)
            }
            setDataFromPiece(piece)
            lookPage.value = piece
        }
    }

    private fun setDataFromPiece(piece: LookPage) {
        imageUrl.postValue(piece.imagePathUrl)
        description.postValue(piece.explanation)
        top.postValue(piece.topInfo)
        bottom.postValue(piece.bottomInfo)
        shoes.postValue(piece.shoeInfo)
        tagList.postValue(listOf(
            piece.keyword1,
            piece.keyword2,
            piece.keyword3
        ))
    }

    fun finish(view: View) {
        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                if(isNewPage.value!!) {
//                    lookbookRepository.postLookPage(
//                        memberEmail = AuthenticationInformation.email.value!!,
//                        explanation = description.value!!,
//                        keyword1 = "",
//                        keyword2 = "",
//                        keyword3 = "",
//                        topInfo = top.value!!,
//                        bottomInfo = bottom.value!!,
//                        shoeInfo = shoes.value!!,
//                        imageFile = null
//                    )
//                } else {
//                    myPageRepository.putMyPageClient()
//                }
//            }
            view.findNavController().navigateUp()
        }
    }

    suspend fun updatePiece() {
        // TODO : 서버 요청
    }
}