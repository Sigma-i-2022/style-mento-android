package com.sigmai.stylemento.global.store

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow

object AuthenticationInfo {
    const val TYPE_CLIENT = 0
    const val TYPE_COORDINATOR = 1

    val email = MutableLiveData("")
    val accessToken = MutableStateFlow("")
    val refreshToken = MutableStateFlow("")
    var userType = TYPE_CLIENT
}