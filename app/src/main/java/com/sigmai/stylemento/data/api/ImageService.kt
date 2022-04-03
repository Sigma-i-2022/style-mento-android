package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.*
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ImageService {
    @GET("v1/api/image")
    fun getImage(
        @Query("uuid") uuid : String
    ) : Call<ResponseWrapper<String>>

    @POST("v1/api/image")
    fun postImage(
        @Part imageFile: MultipartBody.Part
    ) : Call<ResponseWrapper<Unit>>
}