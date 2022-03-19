package com.sigmai.stylemento.data.repository.signup

import com.sigmai.stylemento.data.api.SignupService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.ResponseWrapper
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
}