package com.sigmai.stylemento.ui.mypage.scroll

import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.repository.lookBook.LookBookRepositoryImpl
import com.sigmai.stylemento.data.repository.work.WorkRepositoryImpl
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.domain.usecase.mypage.DeletePieceUseCase
import com.sigmai.stylemento.domain.usecase.mypage.GetPiecesUseCase
import com.sigmai.stylemento.ui.mypage.adapter.PieceScrollListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LookBookScrollViewModel @Inject constructor() : ViewModel(), PieceScrollListener {
    @Inject
    lateinit var getPieceUseCase: GetPiecesUseCase
    @Inject
    lateinit var deletePieceUseCase: DeletePieceUseCase

    val pieceList = MutableLiveData<List<Piece>>()
    val scrollPosition = MutableLiveData(0)
    var isClient = true

    fun loadData(position: Int) {
        viewModelScope.launch {
            val list: List<Piece> = getPieceUseCase()
            pieceList.value = list
            scrollPosition.value = position
        }
    }

    override fun onEdit(view: View, id: Long) {
        val bundle = Bundle()
        bundle.putLong("id", id)
        view.findNavController().navigate(R.id.action_piece_scroll_to_add_piece, bundle)
    }

    override fun onDelete(view: View, id: Long) {
        viewModelScope.launch {
            deletePieceUseCase(id)
            loadData(0)
        }
    }
}