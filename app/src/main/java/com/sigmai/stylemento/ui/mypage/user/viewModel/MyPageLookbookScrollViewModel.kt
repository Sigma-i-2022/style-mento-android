package com.sigmai.stylemento.ui.mypage.user.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.domain.usecase.GetLookbookItemUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageLookbookScrollViewModel : ViewModel() {
    val startBack = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
}