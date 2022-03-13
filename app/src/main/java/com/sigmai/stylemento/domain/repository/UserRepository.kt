package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.User

interface UserRepository {
    fun getUserInfo() : User
}