package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PaymentService {
    @POST("v1/api/payment")
    fun postPayment(
        @Query("reservationSeq") reservationSeq : Long,
        @Query("payType") payType : String,
        @Query("amount") amount : Long,
        @Query("orderName") orderName : String,
        @Query("customerEmail") customerEmail : String,
        @Query("customerName") customerName : String
    ) : Call<ResponseWrapper<Payment>>

    @GET("v1/api/payment/all/{memberSeq}")
    fun getPaymentList(
        @Path("memberSeq") memberSeq : Long,
        @Query("page") page : Int,
        @Query("size") size : Int
    ) : Call<ResponseWrapper<List<PaymentItem>>>

    @GET("v1/api/payment/fail")
    fun getPaymentFail(
        @Path("code") code : String,
        @Query("message") message : String,
        @Query("orderId") orderId : String
    ) : Call<ResponseWrapper<PaymentFail>>

    @GET("v1/api/payment/success")
    fun getPaymentSuccess(
        @Path("paymentKey") paymentKey : String,
        @Query("orderId") orderId : String,
        @Query("amount") amount : Long
    ) : Call<ResponseWrapper<PaymentSuccess>>

    @POST("v1/api/payment/virtual/income")
    fun postVirtualIncome(
        @Query("secret") secret : String,
        @Query("status") status : String,
        @Query("orderId") orderId : String
    ) : Call<ResponseWrapper<Unit>>

    @POST("v1/api/payment/webhoook")
    fun postWebHook(
        @Query("paymentKey") paymentKey : String,
        @Query("status") status : String,
        @Query("orderId") orderId : String,
        @Query("paymentSeq") paymentSeq : Long,
        @Query("eventType") eventType : String
    ) : Call<ResponseWrapper<Unit>>
}