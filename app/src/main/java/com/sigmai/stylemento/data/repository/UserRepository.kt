package com.sigmai.stylemento.data.repository

import com.sigmai.stylemento.data.model.User

interface UserRepository {
    fun getUserInfo() : User
}