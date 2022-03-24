package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*
import java.io.File

interface ClientLookBookService {
    @GET("v1/api/lookPage")
    fun getLookPage(
        @Query("lookSeq") lookSeq: Long
    ): Call<ResponseWrapper<LookPage>>

    @POST("v1/api/lookPage")
    fun postLookPage(
        @Query("memberEmail") memberEmail: String,
        @Query("explanation") explanation: String,
        @Query("keyword1") keyword1: String,
        @Query("keyword2") keyword2: String,
        @Query("keyword3") keyword3: String,
        @Query("topInfo") topInfo: String,
        @Query("bottomInfo") bottomInfo: String,
        @Query("shoeInfo") shoeInfo: String,
        @Part imageFile: MultipartBody.Part
    ): Call<ResponseWrapper<Unit>>

    @GET("v1/api/lookPage/all")
    fun getLookPageAll(
        @Query("email") email: String
    ): Call<ResponseWrapper<List<LookPage>>>

    @POST("v1/api/lookPage/image")
    fun postLookPageImage(
        @Query("lookSeq") lookSeq: Long
    ): Call<ResponseWrapper<Unit>>

    @PUT("v1/api/lookPage/image")
    fun putLookPageImage(
        @Query("lookSeq") lookSeq: Long,
        @Part requestImage: MultipartBody.Part
    ): Call<ResponseWrapper<Unit>>

    @PUT("v1/api/lookPage/info")
    fun putLookPageInfo(
        @Query("lookSeq") lookSeq: Long,
        @Query("clientEmail") clientEmail: String,
        @Query("explanation") explanation: String,
        @Query("keyword1") keyword1: String,
        @Query("keyword2") keyword2: String,
        @Query("keyword3") keyword3: String,
        @Query("topInfo") topInfo: String,
        @Query("bottomInfo") bottomInfo: String,
        @Query("shoeInfo") shoeInfo: String
    ): Call<ResponseWrapper<Unit>>

    @POST("v1/api/lookPage/report")
    fun postLookPageReport(
        @Query("lookSeq") lookSeq: Long,
        @Query("reason") reason: String
    ): Call<ResponseWrapper<Unit>>

    @GET("v1/api/lookPage/report/all")
    fun getLookPageReportAll(
    ): Call<ResponseWrapper<List<LookPage>>>

}