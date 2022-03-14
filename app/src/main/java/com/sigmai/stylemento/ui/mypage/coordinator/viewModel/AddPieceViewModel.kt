package com.sigmai.stylemento.ui.mypage.coordinator.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.global.util.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class AddPieceViewModel : ViewModel() {
    private val userRepository = AppConfigs.coordinatorUserRepository

    val onFinishEvent = SingleLiveEvent<Any>()

    val imageUrl = MutableLiveData("")
    val description = MutableLiveData("")
    val top = MutableLiveData("")
    val bottom = MutableLiveData("")
    val shoes = MutableLiveData("")
    val tagList = MutableLiveData<List<String>>(listOf())


    fun loadPiece(id: Long) {
        CoroutineScope(Dispatchers.IO).launch {
            val piece = userRepository.getUserInfo().pieceList.find { it.id == id }
            piece?.let {
                setDataFromPiece(piece)
            }
        }
    }

    private fun setDataFromPiece(piece: Piece) {
        imageUrl.postValue(piece.imageUrl)
        description.postValue(piece.content)
        top.postValue(piece.top)
        bottom.postValue(piece.pants)
        shoes.postValue(piece.shoes)
        tagList.postValue(piece.tags)
    }

    fun finish() {
        CoroutineScope(Dispatchers.Main).launch {
            val deferred = CoroutineScope(Dispatchers.IO).async {
                updatePiece()
            }
            deferred.await()
            onFinishEvent.call()
        }
    }

    suspend fun updatePiece() {
        // TODO : 서버 요청
    }
}