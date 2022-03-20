package com.sigmai.stylemento.data.repository.signup

import com.sigmai.stylemento.data.model.response.JoinState
import com.sigmai.stylemento.domain.repository.SignupRepository
import javax.inject.Inject

class SignupRepositoryImpl @Inject constructor(private val dataSource: SignupDataSource) : SignupRepository {
    override fun email(email: String): Boolean {
        return dataSource.email(email)
    }

    override fun emailCode(code: String, email: String): Boolean {
        return dataSource.emailCode(code, email)
    }

    override fun join(
        email: String,
        userId: String,
        career: String,
        url1: String?,
        url2: String?,
        url3: String?,
        url4: String?,
        url5: String?
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun joinState(email: String): JoinState {
        TODO("Not yet implemented")
    }

    override fun login(email: String, password: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun signUp(
        userId: String,
        email: String,
        password1: String,
        password2: String
    ): Boolean {
        TODO("Not yet implemented")
    }
}