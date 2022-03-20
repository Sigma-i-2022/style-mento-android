package com.sigmai.stylemento.domain.usecase.signup

import com.sigmai.stylemento.data.repository.signup.SignupRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val repository: SignupRepositoryImpl) {
    suspend operator fun invoke(userId:String, email: String, password: String, passwordConfirm: String) : Boolean {
        return withContext(Dispatchers.IO) {
            repository.signUp(userId, email, password, passwordConfirm)
        }
    }
}