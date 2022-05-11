package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.*
import com.sigmai.stylemento.data.model.response.submall.SubMall
import com.sigmai.stylemento.data.model.response.submall.SubMallAll
import retrofit2.Call
import retrofit2.http.*

interface SubmallService {
    @DELETE("v1/api/submall")
    fun deleteSubMall(
        @Query("crdiEmail") crdiEmail : String
    ) : Call<ResponseWrapper<Unit>>

    @GET("v1/api/submall")
    fun getSubMall(
        @Query("crdiEmail") crdiEmail : String
    ) : Call<ResponseWrapper<SubMall>>

    @POST("v1/api/submall")
    fun postSubMall(
        @Query("account.bank") bank : String,
        @Query("account.accountNumber") accountNumber : String,
        @Query("account.holderName") holderName : String,
        @Query("crdiEmail") crdiEmail : String,
        @Query("companyName") companyName : String,
        @Query("representativeName") representativeName : String,
        @Query("type") type : String,
        @Query("businessNumber") businessNumber : String
    ) : Call<ResponseWrapper<SubMall>>

    @PUT("v1/api/submall")
    fun putSubMall(
        @Query("crdiEmail") crdiEmail : String,
        @Query("account.bank") bank : String,
        @Query("account.accountNumber") accountNumber : String,
        @Query("account.holderName") holderName : String,
        @Query("companyName") companyName : String,
        @Query("representativeName") representativeName : String,
        @Query("businessNumber") businessNumber : String
    ) : Call<ResponseWrapper<SubMall>>

    @GET("v1/api/submall/all")
    fun getSubMallAll() : Call<ResponseWrapper<List<SubMallAll>>>
}