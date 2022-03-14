package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.CoordinatorResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface CoordinatorUserRepository {
    suspend fun getUserInfo(): CoordinatorResponse
    suspend fun deletePiece(id: Long) : Boolean
}