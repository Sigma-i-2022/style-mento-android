package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.reservation.Client
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.data.model.response.reservation.ReservePartTimeReqs
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ReservationService {
    @GET("v1/api/reservation")
    fun getReservationCommon(
        @Query("seq") seq: Long
    ): Call<ResponseWrapper<Common>>

    @POST("v1/api/reservation/client")
    fun postReservationClient(
        @Body reserveReq: Client
    ): Call<ResponseWrapper<Long>>

    @POST("v1/api/reservation/client/pay")
    fun postReservationClientPay(
        @Query("clientId") clientId: String,
        @Query("reservationSeq") reservationSeq: Long,
    ): Call<ResponseWrapper<Unit>>

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

    @POST("v1/api/reservation/crdi/fix")
    fun postReservationCrdiFix(
        @Query("crdiEmail") crdiEmail: String,
        @Query("reservationSeq") reservationSeq: Long,
        @Query("resvTime") resvTime: String
    ): Call<ResponseWrapper<Unit>>
}