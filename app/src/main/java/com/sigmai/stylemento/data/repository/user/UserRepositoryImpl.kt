package com.sigmai.stylemento.data.repository.user

import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {
    override fun getUserInfo(): User = Client.getUserInfo()
}