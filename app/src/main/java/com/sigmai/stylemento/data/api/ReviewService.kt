package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.review.Review
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ReviewService {
    @GET("v1/api/review")
    fun getReview(
        @Query("email") email: String
    ): Call<ResponseWrapper<List<Review>>>

    @POST("v1/api/review")
    fun postReview(
        @Query("reservationSeq") reservationSeq: Long,
        @Query("reviewerId") reviewerId: String,
        @Query("reviewerEmail") reviewerEmail: String,
        @Query("coordinatorId") coordinatorId: String,
        @Query("coordinatorEmail") coordinatorEmail: String,
        @Query("star") star: Int,
        @Query("sex") sex: String,
        @Query("height") height: String,
        @Query("weight") weight: String,
        @Query("content") content: String
    ): Call<ResponseWrapper<Unit>>

    @GET("v1/api/review/report")
    fun getReviewReport(): Call<ResponseWrapper<Review>>

    @POST("v1/api/review/report")
    fun postReviewReport(
        @Query("reservationSeq") reservationSeq: Long,
        @Query("reason") reason: String,
        @Query("content") content: String
    ): Call<ResponseWrapper<Unit>>

    @DELETE("v1/api/review/reply")
    fun deleteReviewReply(
        @Query("replySeq") replySeq: Long
    ): Call<ResponseWrapper<Unit>>
}