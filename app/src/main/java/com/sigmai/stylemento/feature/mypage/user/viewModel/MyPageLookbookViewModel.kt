package com.sigmai.stylemento.feature.mypage.user.viewModel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.usecase.UserUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent

class MyPageLookbookViewModel : ViewModel() {
    val startAddLookbook = SingleLiveEvent<Any>()

    fun onAddLookbookClick(){
        startAddLookbook.call()
    }
}