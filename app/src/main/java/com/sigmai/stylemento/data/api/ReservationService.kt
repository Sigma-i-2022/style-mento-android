package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.reservation.Client
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.data.model.response.reservation.ResvTime
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ReservationService {
    @POST("v1/api/reservation/client")
    fun client(
        @Body reserveReq: Client
    ): Call<ResponseWrapper<Unit>>

    @POST("v1/api/reservation/client/cancel")
    fun clientCancel(
        @Query("clientId") clientId: String,
        @Query("reservationSeq") reservationSeq: Long,
        @Query("reason") reason: String,
    ): Call<ResponseWrapper<Unit>>

    @POST("v1/api/reservation/client/pay")
    fun clientPay(
        @Query("clientId") clientId: String,
        @Query("reservationSeq") reservationSeq: Long,
    ): Call<ResponseWrapper<Unit>>

    @GET("v1/api/reservation/common/all")
    fun commonAll(

    ): Call<ResponseWrapper<Common>>

    @POST("v1/api/reservation/common/hide")
    fun clientHide(
        @Query("memberEmail") memberEmail: String,
        @Query("reservationSeq") reservationSeq: Long,
    ): Call<ResponseWrapper<Unit>>

    @GET("v1/api/reservation/common/list")
    fun commonList(
        @Query("email") email: String,
    ): Call<ResponseWrapper<Unit>>

    @POST("v1/api/reservation/crdi/cancel")
    fun crdiCancel(
        @Query("crdiId") crdiId: String,
        @Query("reservationSeq") reservationSeq: Long,
        @Query("reason") reason: String,
    ): Call<ResponseWrapper<Unit>>

    @POST("v1/api/reservation/crdi/fix")
    fun crdiFix(
        @Query("clientId") clientId: String,
        @Query("reservationSeq") reservationSeq: Long,
        @Body resvTime: ResvTime,
    ): Call<ResponseWrapper<Unit>>
}