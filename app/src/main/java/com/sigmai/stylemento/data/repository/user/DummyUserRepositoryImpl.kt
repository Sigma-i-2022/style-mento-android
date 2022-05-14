package com.sigmai.stylemento.data.repository.user

import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.domain.repository.UserRepository

class DummyUserRepositoryImpl : UserRepository {
    override fun getUserInfo(): User = User("test", "test@email")
}