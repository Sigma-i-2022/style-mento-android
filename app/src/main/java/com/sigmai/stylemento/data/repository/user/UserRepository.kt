package com.sigmai.stylemento.data.repository.user

import com.sigmai.stylemento.data.model.User

interface UserRepository {
    fun getUserInfo() : User
}