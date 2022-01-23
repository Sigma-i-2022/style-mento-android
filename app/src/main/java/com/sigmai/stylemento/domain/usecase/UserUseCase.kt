package com.sigmai.stylemento.domain.usecase

import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.data.repository.UserRepository

class UserUseCase(val userRepository: UserRepository) {
    fun getUser() : User {
        return userRepository.getUserInfo()
    }
}