package com.sigmai.stylemento.global.store

import androidx.lifecycle.MutableLiveData
import com.sigmai.stylemento.data.model.User

class UserStore {
    val user = MutableLiveData<User>()
}