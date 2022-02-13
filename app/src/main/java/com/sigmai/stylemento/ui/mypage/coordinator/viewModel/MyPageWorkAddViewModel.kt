package com.sigmai.stylemento.ui.mypage.coordinator.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageWorkAddViewModel : ViewModel() {
    val startBack = SingleLiveEvent<Any>()
    val startSave = SingleLiveEvent<Any>()
    val startTagAddition = SingleLiveEvent<Any>()

    fun onBackClick() {
        startBack.call()
    }
    fun onSaveClick() {
        startSave.call()
    }
    fun onTagAdditionClick() {
        startTagAddition.call()
    }
}