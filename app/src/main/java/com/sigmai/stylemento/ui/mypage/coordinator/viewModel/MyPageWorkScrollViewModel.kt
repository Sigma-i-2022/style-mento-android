package com.sigmai.stylemento.ui.mypage.coordinator.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.domain.usecase.GetLookbookItemUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageWorkScrollViewModel : ViewModel() {
    val startBack = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
}