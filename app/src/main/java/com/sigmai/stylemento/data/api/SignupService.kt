package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.request.signup.LoginReq
import com.sigmai.stylemento.data.model.response.signup.JoinState
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SignupService {
    @POST("v1/api/join/email")
    fun email(@Query("email") email: String): Call<ResponseWrapper<Unit>>

    @POST("v1/api/join/emailCode")
    fun emailCode(
        @Query("code") code: String,
        @Query("email") email: String
    ): Call<ResponseWrapper<Unit>>

    @POST("v1/api/join/join")
    fun join(
        @Query("email") email: String,
        @Query("career") career: String,
        @Query("url1") url1: String?,
        @Query("url2") url2: String?,
        @Query("url3") url3: String?,
        @Query("url4") url4: String?,
        @Query("url5") url5: String?
    ): Call<ResponseWrapper<Unit>>

    @GET("v1/api/join/joinState")
    fun joinState(
        @Query("email") email: String
    ): Call<ResponseWrapper<JoinState>>

    @POST("v1/api/join/login")
    fun login(
        @Body loginReq: LoginReq
    ): Call<ResponseWrapper<Unit>>

    @POST("v1/api/join/signUp")
    fun signUp(
        @Query("userId") userId: String,
        @Query("email") email: String,
        @Query("password1") password1: String,
        @Query("password2") password2: String
    ): Call<ResponseWrapper<Unit>>
}