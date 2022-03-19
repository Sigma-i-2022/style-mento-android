package com.sigmai.stylemento.domain.usecase.signup

import com.sigmai.stylemento.data.repository.signup.SignupRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SendAuthenticationCodeUseCase @Inject constructor(private val repository: SignupRepositoryImpl) {
    suspend operator fun invoke(email: String) : Boolean {
        return withContext(Dispatchers.IO) {
            repository.email(email)
        }
    }
}