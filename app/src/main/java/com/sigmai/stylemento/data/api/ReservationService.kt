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
    fun postReservationClient(
        @Body reserveReq: Client
    ): Call<ResponseWrapper<Unit>>

//    @POST("v1/api/reservation/client/cancel")
//    fun postReservationClientCancel(
//        @Query("clientId") clientId: String,
//        @Query("reservationSeq") reservationSeq: Long,
//        @Query("reason") reason: String,
//    ): Call<ResponseWrapper<Unit>>

    @POST("v1/api/reservation/client/pay")
    fun postReservationClientPay(
        @Query("clientId") clientId: String,
        @Query("reservationSeq") reservationSeq: Long,
    ): Call<ResponseWrapper<Unit>>

//    @GET("v1/api/reservation/common/all")
//    fun getReservationCommonAll(
//
//    ): Call<ResponseWrapper<List<Common>>>

    @POST("v1/api/reservation/common/hide")
    fun postReservationCommonHide(
        @Query("memberEmail") memberEmail: String,
        @Query("reservationSeq") reservationSeq: Long
    ): Call<ResponseWrapper<Unit>>

    @GET("v1/api/reservation/common/list")
    fun getReservationCommonList(
        @Query("email") email: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Call<ResponseWrapper<List<Common>>>

//    @POST("v1/api/reservation/crdi/cancel")
//    fun postReservationCrdiCancel(
//        @Query("crdiId") crdiId: String,
//        @Query("reservationSeq") reservationSeq: Long,
//        @Query("reason") reason: String,
//    ): Call<ResponseWrapper<Unit>>

    @POST("v1/api/reservation/crdi/fix")
    fun postReservationCrdiFix(
        @Query("crdiId") crdiId: String,
        @Query("reservationSeq") reservationSeq: Long,
        @Body resvTime: ResvTime,
    ): Call<ResponseWrapper<Unit>>
}