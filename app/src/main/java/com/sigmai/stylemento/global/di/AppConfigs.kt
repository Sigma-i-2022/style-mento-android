package com.sigmai.stylemento.global.di

import com.sigmai.stylemento.data.repository.MemoryUserRepository
import com.sigmai.stylemento.data.repository.UserRepository

object AppConfigs {
    val userRepository: UserRepository = MemoryUserRepository()
}