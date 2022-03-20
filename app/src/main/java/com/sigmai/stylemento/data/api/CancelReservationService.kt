package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.cancel.CancelItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CancelReservationService {
    @GET("v1/api/cancel/all")
    fun getCancelAll(@Query("searchType") searchType : String) : Call<ResponseWrapper<List<CancelItem>>>
}