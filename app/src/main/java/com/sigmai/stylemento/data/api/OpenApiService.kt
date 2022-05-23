package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface OpenApiService {
    @GET("v1/api/openapi/account")
    fun getAccount(
        @Query("crdiSeq") crdiSeq : Long
    ) : Call<ResponseWrapper<AccountInfo>>

    @POST("v1/api/openapi/realname")
    fun postRealName(
        @Query("crdiSeq") crdiSeq : Long,
        @Query("bankCode") bankCode : String,
        @Query("bankAccount") bankAccount : String,
        @Query("realName") realName : String,
        @Query("birthday") birthday : String
    ) : Call<ResponseWrapper<Boolean>>

    @POST("v1/api/openapi/token")
    fun postToken() : Call<ResponseWrapper<Unit>>
}