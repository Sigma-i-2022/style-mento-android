package com.sigmai.stylemento.ui.mypage

import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.data.repository.lookBook.LookBookRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInformation
import com.sigmai.stylemento.ui.mypage.adapter.PieceScrollListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LookBookScrollViewModel @Inject constructor() : ViewModel(), PieceScrollListener {
    @Inject
    lateinit var lookBookRepository: LookBookRepositoryImpl

    val pieceList = MutableLiveData<List<LookPage>>()
    val scrollPosition = MutableLiveData(0)

    fun loadData(position: Int) {
        viewModelScope.launch {
            val list = withContext(Dispatchers.IO) {
                lookBookRepository.getLookPageAll(AuthenticationInformation.email.value!!)
            }
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
            withContext(Dispatchers.IO) {
                lookBookRepository.deleteLookPage(id)
            }
            loadData(0)
        }
    }
}