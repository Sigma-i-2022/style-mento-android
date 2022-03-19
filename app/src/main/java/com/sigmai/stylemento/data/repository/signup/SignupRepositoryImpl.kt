package com.sigmai.stylemento.data.repository.signup

import com.sigmai.stylemento.domain.repository.SignupRepository
import javax.inject.Inject

class SignupRepositoryImpl @Inject constructor(private val dataSource: SignupDataSource) : SignupRepository {
    override fun email(email: String): Boolean {
        return dataSource.email(email)
    }
}