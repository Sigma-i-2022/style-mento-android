package com.sigmai.stylemento.global.usecase

import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.data.repository.UserRepository

class UserUseCase(val userRepository: UserRepository) {
    fun getUser() : User {
        return userRepository.getUserInfo()
    }
}