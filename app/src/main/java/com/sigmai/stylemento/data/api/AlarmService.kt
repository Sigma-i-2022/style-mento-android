package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface AlarmService {
    @POST("v1/api/alarm")
    fun postAlarm(
        @Query("email") email: String,
        @Query("alarmMsg") alarmMsg: String,
    ): Call<ResponseWrapper<Unit>>
}