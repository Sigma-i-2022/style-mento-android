package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.Member
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SignupService {
    @POST("v1/api/email")
    fun email(@Query("email") email: String): Call<ResponseWrapper<Unit>>
}