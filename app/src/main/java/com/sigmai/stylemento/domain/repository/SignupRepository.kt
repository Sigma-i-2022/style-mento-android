package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.JoinState
import retrofit2.Response

interface SignupRepository {
    fun email(email: String): Boolean
    fun emailCode(code: String, email: String): Boolean
    fun join(email: String, userId: String, career: String, url1: String?, url2: String?, url3: String?, url4: String?, url5: String?): Boolean
    fun joinState(email: String): JoinState
    fun login(email: String, password: String): Boolean
    fun signUp(userId: String, email: String, password1: String, password2: String): Boolean
}