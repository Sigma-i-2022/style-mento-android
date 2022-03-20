package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.report.Report
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ReportService {
    @POST("v1/api/report")
    fun postReport(
        @Query("memberSeq") memberSeq: Long,
        @Query("memberEmail") memberEmail: String,
        @Query("reportTitle") reportTitle: String,
        @Query("reportContent") reportContent: String,
    ): Call<ResponseWrapper<Unit>>

    @GET("v1/api/report/all")
    fun getReportAll(): Call<ResponseWrapper<Report>>

    @GET("v1/api/report/member")
    fun getReportMember(
        @Query("memberSeq") memberSeq: Long
    ): Call<ResponseWrapper<Report>>
}