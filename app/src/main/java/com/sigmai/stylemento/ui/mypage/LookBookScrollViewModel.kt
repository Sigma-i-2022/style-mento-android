package com.sigmai.stylemento.ui.mypage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.data.repository.lookBook.LookBookRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInformation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LookBookScrollViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var lookBookRepository: LookBookRepositoryImpl

    val pieceList = MutableLiveData<List<LookPage>>()

    fun loadData() {
        viewModelScope.launch {
            val list = withContext(Dispatchers.IO) {
                lookBookRepository.getLookPageAll(AuthenticationInformation.email.value!!)
            }
            pieceList.value = list
        }
    }
}