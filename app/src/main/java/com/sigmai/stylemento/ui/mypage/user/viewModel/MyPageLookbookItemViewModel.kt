package com.sigmai.stylemento.ui.mypage.user.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.domain.usecase.GetLookbookItemUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageLookbookItemViewModel : ViewModel() {
    private val _item = MutableLiveData<LookbookItem>()
    private val getLookbookItemUseCase = GetLookbookItemUseCase()

    val item: LiveData<LookbookItem> get() = _item

    val startBack = SingleLiveEvent<Any>()
    val startRevision = SingleLiveEvent<Any>()
    val startDelete = SingleLiveEvent<Any>()
    val startInstruction = SingleLiveEvent<Any>()

    fun onBackClick(){
        startBack.call()
    }
    fun onRevisionClick(){
        startRevision.call()
    }
    fun onDeleteClick(){
        startDelete.call()
    }
    fun onInstructionClick(){
        startInstruction.call()
    }

    fun setItemInfo(position : Int) {
        _item.postValue(getLookbookItemUseCase(position))
    }
}