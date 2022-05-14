package com.sigmai.stylemento.data.model

import com.sigmai.stylemento.global.constant.UserType


object Client {
    private var userInfo = User("test", "test@email")
    fun getUserInfo() : User{
        return userInfo
    }
}