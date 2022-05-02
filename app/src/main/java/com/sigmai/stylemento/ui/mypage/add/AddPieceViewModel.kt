package com.sigmai.stylemento.ui.mypage.add

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.data.repository.image.ImageRepositoryImpl
import com.sigmai.stylemento.data.repository.lookBook.LookBookRepositoryImpl
import com.sigmai.stylemento.data.repository.myPage.MyPageRepositoryImpl
import com.sigmai.stylemento.data.repository.work.WorkRepositoryImpl
import com.sigmai.stylemento.domain.repository.WorkRepository
import com.sigmai.stylemento.global.store.AuthenticationInformation
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class AddPieceViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var myPageRepository: MyPageRepositoryImpl
    @Inject
    lateinit var lookbookRepository: LookBookRepositoryImpl
    @Inject
    lateinit var imageRepository: ImageRepositoryImpl
    @Inject
    lateinit var workRepository: WorkRepositoryImpl

    val lookPage = MutableLiveData<LookPage>()

    val onFinishEvent = SingleLiveEvent<Any>()
    val onImageEvent = SingleLiveEvent<Any>()

    val imageUrl = MutableLiveData("")
    val description = MutableLiveData("")
    val top = MutableLiveData("")
    val bottom = MutableLiveData("")
    val shoes = MutableLiveData("")
    val tagList = MutableLiveData<List<String>>(listOf())
    val isNewPage = MutableLiveData(true)
    var lookPageId = -1L
    var uuid = ""

    fun loadPiece(id: Long) {
        if(id < 0) return
        else lookPageId = id

        isNewPage.value = false

        viewModelScope.launch {
            val piece = withContext(Dispatchers.IO) {
                if(AuthenticationInformation.userType == AuthenticationInformation.TYPE_CLIENT) lookbookRepository.getLookPage(id)
                else workRepository.getCrdiWork(id)
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
            if(AuthenticationInformation.userType == AuthenticationInformation.TYPE_CLIENT) {
                lookbookRepository.putLookPageInfo(
                    lookSeq = lookPageId,
                    clientEmail = AuthenticationInformation.email.value!!,
                    explanation = description.value!!,
                    topInfo = top.value!!,
                    bottomInfo = bottom.value!!,
                    shoeInfo = shoes.value!!,
                    keyword1 = "WARM",
                    keyword2 = "COOL",
                    keyword3 = "MINIMAL"
                )
                lookbookRepository.putLookPageImage(
                    lookSeq = lookPageId,
                    uuid = uuid
                )
            }

            if(AuthenticationInformation.userType == AuthenticationInformation.TYPE_COORDINATOR) {
                workRepository.putCrdiWork(
                    workSeq = lookPageId,
                    crdiEmail = AuthenticationInformation.email.value!!,
                    explanation = description.value!!,
                    topInfo = top.value!!,
                    bottomInfo = bottom.value!!,
                    shoeInfo = shoes.value!!,
                    height = "0",
                    weight = "0",
                    keyword1 = "WARM",
                    keyword2 = "COOL",
                    keyword3 = "MINIMAL"
                )
                workRepository.putCrdiWorkImage(lookPageId, uuid)
            }
        }
    }

    private suspend fun addPiece() {
        withContext(Dispatchers.IO) {
            if(AuthenticationInformation.userType == AuthenticationInformation.TYPE_CLIENT) {
                lookbookRepository.postLookPage(
                    memberEmail = AuthenticationInformation.email.value!!,
                    explanation = description.value!!,
                    keyword1 = "WARM",
                    keyword2 = "COOL",
                    keyword3 = "MINIMAL",
                    topInfo = top.value!!,
                    bottomInfo = bottom.value!!,
                    shoeInfo = shoes.value!!,
                    uuid = uuid
                )
            }

            if(AuthenticationInformation.userType == AuthenticationInformation.TYPE_COORDINATOR) {
                workRepository.postCrdiWork(
                    crdiEmail = AuthenticationInformation.email.value!!,
                    explanation = description.value!!,
                    topInfo = top.value!!,
                    bottomInfo = bottom.value!!,
                    shoeInfo = shoes.value!!,
                    weight = "0",
                    height = "0",
                    keyword1 = "WARM",
                    keyword2 = "COOL",
                    keyword3 = "MINIMAL",
                    uuid = uuid
                )
            }
        }
    }

    fun uploadImage(file: MultipartBody.Part) {
        viewModelScope.launch {
            uuid = withContext(Dispatchers.IO) {
                imageRepository.postImage(file)
            }
        }
    }

    fun onImageClick() {
        onImageEvent.call()
    }
}