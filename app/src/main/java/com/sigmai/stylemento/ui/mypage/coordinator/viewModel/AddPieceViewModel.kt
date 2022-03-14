package com.sigmai.stylemento.ui.mypage.coordinator.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.entity.Piece
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddPieceViewModel : ViewModel() {
    val piece = MutableLiveData<Piece>()
    private val userRepository = AppConfigs.coordinatorUserRepository

    fun loadPiece(id: Long) {
        CoroutineScope(Dispatchers.IO).launch {
            piece.postValue(userRepository.getUserInfo().pieceList.find { it.id == id })
        }
    }
}