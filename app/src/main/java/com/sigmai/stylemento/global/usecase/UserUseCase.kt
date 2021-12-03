package com.sigmai.stylemento.global.usecase

import com.sigmai.stylemento.data.repository.UserRepository

class UserUseCase(private val userRepository: UserRepository) {
    suspend fun getUser() {
        userRepository.getUserInfo()
    }
}