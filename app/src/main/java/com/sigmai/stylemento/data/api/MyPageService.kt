package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.myPage.MyPageClient
import com.sigmai.stylemento.data.model.response.myPage.MyPageCrdi
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*
import java.io.File

interface MyPageService {
    @GET("v1/api/mypage/client")
    fun getMyPageClient(
        @Query("email") email: String
    ): Call<ResponseWrapper<MyPageClient>>

    @PUT("v1/api/mypage/client")
    fun putMyPageClient(
        @Query("email") email: String,
        @Query("userId") userId: String,
        @Query("intro") intro: String
    ): Call<ResponseWrapper<Unit>>

    @GET("v1/api/mypage/crdi")
    fun getMyPageCrdi(
        @Query("email") email: String
    ): Call<ResponseWrapper<MyPageCrdi>>

    @POST("v1/api/mypage/crdi")
    fun postMyPageCrdi(
        @Query("email") email: String,
        @Query("userId") userId: String,
        @Query("intro") intro: String,
        @Query("expertYN") expertYN: String,
        @Part profileImage: MultipartBody.Part
    ): Call<ResponseWrapper<Unit>>

    @PUT("v1/api/mypage/crdi")
    fun putMyPageCrdi(
        @Query("email") email: String,
        @Query("userId") userId: String,
        @Query("intro") intro: String
    ): Call<ResponseWrapper<Unit>>

    @Multipart
    @POST("v1/api/mypage/image")
    fun postMyPageImage(
        @Query("memberEmail") memberEmail: String,
        @Part memberImageFile: MultipartBody.Part
    ): Call<ResponseWrapper<Unit>>
}