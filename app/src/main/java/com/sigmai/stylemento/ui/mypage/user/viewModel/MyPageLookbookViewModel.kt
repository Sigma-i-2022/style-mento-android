package com.sigmai.stylemento.ui.mypage.user.viewModel

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageLookbookViewModel : ViewModel() {
    val startAddLookbook = SingleLiveEvent<Any>()

    fun onAddLookbookClick(){
        startAddLookbook.call()
    }
}