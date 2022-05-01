package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.data.model.response.work.Coordinator
import com.sigmai.stylemento.data.model.response.work.Work
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface CoordinatorWorkService {
    @GET("v1/api/crdi/work")
    fun getCrdiWork(@Query("workSeq") workSeq: Long): Call<ResponseWrapper<LookPage>>

    @POST("v1/api/crdi/work")
    fun postCrdiWork(
        @Query("crdiEmail") crdiEmail: String,
        @Query("explanation") explanation: String,
        @Query("weight") weight: String,
        @Query("height") height: String,
        @Query("topInfo") topInfo: String,
        @Query("bottomInfo") bottomInfo: String,
        @Query("shoeInfo") shoeInfo: String,
        @Query("keyword1") keyword1: String,
        @Query("keyword2") keyword2: String,
        @Query("keyword3") keyword3: String,
        @Query("uuid") uuid: String
    ): Call<ResponseWrapper<Unit>>

    @GET("v1/api/crdi/work/all")
    fun getCrdiWorkAll(@Query("crdiEmail") crdiEmail: String): Call<ResponseWrapper<List<Work>>>

    @GET("v1/api/crdi/work/list")
    fun getCrdiList(@Query("email") email: String): Call<ResponseWrapper<List<Coordinator>>>

    @PUT("v1/api/crdi/work/update")
    fun putCrdiWork(
        @Query("workSeq") workSeq: Long,
        @Query("crdiEmail") crdiEmail: String,
        @Query("explanation") explanation: String,
        @Query("weight") weight: String,
        @Query("height") height: String,
        @Query("topInfo") topInfo: String,
        @Query("bottomInfo") bottomInfo: String,
        @Query("shoeInfo") shoeInfo: String,
        @Query("keyword1") keyword1: String,
        @Query("keyword2") keyword2: String,
        @Query("keyword3") keyword3: String
    ): Call<ResponseWrapper<Unit>>
}