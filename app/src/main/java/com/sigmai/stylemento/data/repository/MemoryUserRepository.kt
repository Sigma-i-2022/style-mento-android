package com.sigmai.stylemento.data.repository

import com.sigmai.stylemento.data.model.User

class MemoryUserRepository : UserRepository {
    override fun getUserInfo(): User {
        return User("user_name", "test@gmail.com")
    }
}