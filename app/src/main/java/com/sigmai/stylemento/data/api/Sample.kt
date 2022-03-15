package com.sigmai.stylemento.data.api

import android.telecom.Call
import retrofit2.http.GET

interface Sample {
    @GET("/")
    fun login(): Call
}