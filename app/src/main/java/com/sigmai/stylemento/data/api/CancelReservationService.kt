package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.cancel.CancelItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CancelReservationService {
    @POST("v1/api/cancelPayment")
    fun postCancelPayment(
        @Query("email") email : String,
        @Query("reservationSeq") reservationSeq : Long,
        @Query("paymentKey") paymentKey : String,
        @Query("cancelReason") cancelReason : String,
        @Query("bank") bank : String,
        @Query("accountNumber") accountNumber : String,
        @Query("holderName") holderName : String
    ) : Call<ResponseWrapper<Unit>>

    @GET("v1/api/cancelPayment")
    fun getCancelList(
        @Query("memberEmail") memberEmail : String,
        @Query("page") page : Int,
        @Query("size") size : Int
    ) : Call<ResponseWrapper<List<CancelItem>>>
}