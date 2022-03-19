package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.ResponseWrapper
import retrofit2.Response

interface SignupRepository {
    fun email(email: String): Boolean
}