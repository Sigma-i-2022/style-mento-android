package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.*
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ImageService {
    @GET("v1/api/image")
    fun getImage(
        @Query("uuid") uuid : String
    ) : Call<ResponseWrapper<String>>

    @Multipart
    @POST("v1/api/image")
    fun postImage(
        @Part imageFile: MultipartBody.Part
    ) : Call<ResponseWrapper<String>>
}