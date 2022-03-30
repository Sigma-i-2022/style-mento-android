package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.*
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface BlockService {
    @POST("v1/api/block")
    fun postBlock(
        @Query("email") email : String,
        @Query("crdiEmail") crdiEmail : String
    ) : Call<ResponseWrapper<Unit>>
}