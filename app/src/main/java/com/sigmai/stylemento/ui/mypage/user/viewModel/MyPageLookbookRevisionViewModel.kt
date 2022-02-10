package com.sigmai.stylemento.ui.mypage.user.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageLookbookRevisionViewModel : ViewModel() {
    private val _item = MutableLiveData<LookbookItem>()

    val item: LiveData<LookbookItem> get() = _item

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

    fun setItemInfo(item : LookbookItem) {
        _item.postValue(item)
    }
}