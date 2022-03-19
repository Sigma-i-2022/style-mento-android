package com.sigmai.stylemento.data.repository.signup

import com.sigmai.stylemento.data.api.SignupService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.JoinState
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class SignupDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<SignupService>()

    fun email(email: String) : Boolean {
        return service.email(email).execute().body()?.success ?: false
    }

    fun emailCode(code: String, email: String) : Boolean {
        return service.emailCode(code, email).execute().body()?.success ?: false
    }

    fun join(email: String, userId: String, career: String, url1: String?, url2: String?, url3: String?, url4: String?, url5: String?) : Boolean {
        return service.join(email, userId, career, url1, url2, url3, url4, url5).execute().body()?.success ?: false
    }

    fun joinState(email: String) : JoinState {
        return service.joinState(email).execute().body()!!.data
    }

    fun login(email: String, password: String) : Boolean {
        return service.login(email, password).execute().body()?.success ?: false
    }

    fun signUp(userId: String, email: String, password1: String, password2: String) : Boolean {
        return service.signUp(userId, email, password1, password2).execute().body()?.success ?: false
    }
}