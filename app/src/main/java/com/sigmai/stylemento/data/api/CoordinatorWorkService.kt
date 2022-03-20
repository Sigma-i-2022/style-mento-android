package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.work.Work
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query
import java.io.File

interface CoordinatorWorkService {
    @GET("v1/api/crdi/work")
    fun getCrdiWork(@Query("workSeq") workSeq : Long): Call<ResponseWrapper<Unit>>

    @POST("v1/api/crdi/work")
    fun postCrdiWork(
        @Query("crdiEmail") crdiEmail : String,
        @Query("explanation") explanation : String,
        @Query("weight") weight : String,
        @Query("height") height : String,
        @Query("topInfo") topInfo : String,
        @Query("bottomInfo") bottomInfo : String,
        @Query("shoeInfo") shoeInfo : String,
        @Part imageFile: MultipartBody.Part
    ): Call<ResponseWrapper<Unit>>

    @GET("v1/api/crdi/work/all")
    fun getCrdiWorkAll(@Query("crdiEmail") crdiEmail : String): Call<ResponseWrapper<List<Work>>>
}