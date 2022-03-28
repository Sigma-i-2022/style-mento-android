package com.sigmai.stylemento.ui.mypage

import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.data.model.response.work.Work
import com.sigmai.stylemento.data.repository.lookBook.LookBookRepositoryImpl
import com.sigmai.stylemento.data.repository.work.WorkRepositoryImpl
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.global.store.AuthenticationInformation
import com.sigmai.stylemento.ui.mypage.adapter.PieceScrollListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LookBookScrollViewModel @Inject constructor() : ViewModel(), PieceScrollListener {
    @Inject
    lateinit var lookBookRepository: LookBookRepositoryImpl
    @Inject
    lateinit var workRepository: WorkRepositoryImpl

    val pieceList = MutableLiveData<List<Piece>>()
    val scrollPosition = MutableLiveData(0)
    var isClient = true

    fun loadData(position: Int) {
        viewModelScope.launch {
            val list: List<Any> = withContext(Dispatchers.IO) {
                if(isClient) lookBookRepository.getLookPageAll(AuthenticationInformation.email.value!!)
                else workRepository.getCrdiWorkAll(AuthenticationInformation.email.value!!)
            }.map {
                if(it is LookPage) Piece.from(it)
                if(it is Work) {
                    Timber.e("실행")
                    Piece.from(it)
                }
            }

            pieceList.value = list as List<Piece>
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
            withContext(Dispatchers.IO) {
                lookBookRepository.deleteLookPage(id)
            }
            loadData(0)
        }
    }
}