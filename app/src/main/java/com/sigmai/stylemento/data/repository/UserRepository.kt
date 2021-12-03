package com.sigmai.stylemento.data.repository

interface UserRepository {
    suspend fun getUserInfo()
}