package com.sigmai.stylemento.data.repository

import com.sigmai.stylemento.data.model.User

class MemoryUserRepository(var user: User) : UserRepository {
    override suspend fun getUserInfo() {
        user = User("user_name", "test@gmail.com")
    }
}