package com.sigmai.stylemento.ui.mypage.add

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.data.repository.lookBook.LookBookRepositoryImpl
import com.sigmai.stylemento.data.repository.myPage.MyPageRepositoryImpl
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
    var lookPageId = -1L

    fun loadPiece(id: Long) {
        if(id < 0) return
        else lookPageId = id

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
            if(lookPageId >= 0) updatePiece()
            else addPiece()
            view.findNavController().navigateUp()
        }
    }

    private suspend fun updatePiece() {
        withContext(Dispatchers.IO) {
            lookbookRepository.putLookPageInfo(
                lookSeq = lookPageId,
                clientEmail = AuthenticationInformation.email.value!!,
                explanation = description.value!!,
                keyword1 = "WARM",
                keyword2 = "COOL",
                keyword3 = "MINIMAL",
                topInfo = top.value!!,
                bottomInfo = bottom.value!!,
                shoeInfo = shoes.value!!
            )
        }
    }

    private suspend fun addPiece() {
        withContext(Dispatchers.IO) {
//            lookbookRepository.postLookPage()
        }
    }
}