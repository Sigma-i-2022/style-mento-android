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
        @Query("memberSeq") memberSeq : Long,
        @Query("reservationSeq") reservationSeq : Long,
        @Query("paymentKey") paymentKey : String,
        @Query("cancelReason") cancelReason : String,
        @Query("bank") bank : String,
        @Query("accountNumber") accountNumber : String,
        @Query("holderName") holderName : String
    ) : Call<ResponseWrapper<Unit>>

    @GET("v1/api/cancelPayment/{memberSeq}")
    fun getCancelList(
        @Path("memberSeq") memberSeq : Long,
        @Query("page") page : Int,
        @Query("size") size : Int
    ) : Call<ResponseWrapper<List<CancelItem>>>
}