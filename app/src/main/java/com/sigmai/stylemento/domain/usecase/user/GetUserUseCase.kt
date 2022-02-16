package com.sigmai.stylemento.domain.usecase.user

import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.data.repository.UserRepository

class GetUserUseCase(val userRepository: UserRepository) {
    operator fun invoke() : User {
        return userRepository.getUserInfo()
    }
}