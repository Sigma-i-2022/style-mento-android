package com.sigmai.stylemento.domain.usecase.signup

import com.sigmai.stylemento.data.repository.signup.SignupRepositoryImpl
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.domain.repository.CoordinatorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class JoinUseCase @Inject constructor(private val repository: SignupRepositoryImpl) {
    suspend operator fun invoke(email: String, userId: String, description: String, urls: List<String>) : Boolean {
        val urlOrNulls = (0..4).map {
            if(urls.size > it) urls[it] else null
        }

        return withContext(Dispatchers.IO) {
            repository.join(email, userId, description, urlOrNulls[0], urlOrNulls[1], urlOrNulls[2], urlOrNulls[3], urlOrNulls[4])
        }
    }
}