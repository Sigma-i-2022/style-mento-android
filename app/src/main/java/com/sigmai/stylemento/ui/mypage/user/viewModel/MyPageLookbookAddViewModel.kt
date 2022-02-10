package com.sigmai.stylemento.ui.mypage.user.viewModel

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageLookbookAddViewModel : ViewModel() {
    val startBack = SingleLiveEvent<Any>()
    val startSave = SingleLiveEvent<Any>()
    val startTagAdd = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
    fun onSaveClick(){
        startSave.call()
    }
    fun onTagAddClick(){
        startTagAdd.call()
    }
}