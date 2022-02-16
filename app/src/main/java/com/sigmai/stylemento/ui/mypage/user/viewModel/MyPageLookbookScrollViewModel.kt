package com.sigmai.stylemento.ui.mypage.user.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.domain.usecase.GetLookbookItemUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent
import com.sigmai.stylemento.ui.mypage.user.adapter.UserLookbookItemAdapter2

class MyPageLookbookScrollViewModel : ViewModel() {
    val startBack = SingleLiveEvent<Any>()
    var position = MutableLiveData(0)

    fun onBackClick(){
        startBack.call()
    }

    fun updateAdapterAfterDeleteLookbook(position : Int) {
        Client.removeLookbookItem(position)
        this.position.value = position - 1
    }
}