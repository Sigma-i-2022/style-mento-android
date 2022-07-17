package com.sigmai.stylemento.domain.usecase.signup

import com.sigmai.stylemento.data.repository.member.MemberRepositoryImpl
import com.sigmai.stylemento.data.repository.signup.SignupRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: SignupRepositoryImpl, private val memberRepository: MemberRepositoryImpl) {
    suspend operator fun invoke(email: String, password: String, fcmToken: String) : Int? {
        return withContext(Dispatchers.IO) {
            val loginResult = repository.login(email, password, fcmToken)
            if(loginResult) {
                val member = memberRepository.getMemberByEmail(email)
                if(member.crdiYn == "Y") AuthenticationInfo.TYPE_COORDINATOR
                else AuthenticationInfo.TYPE_CLIENT
            }
            else null
        }
    }
}