package com.sigmai.stylemento.data.api

import retrofit2.Call
import retrofit2.http.GET

interface CancelReservationService {
    @GET("v1/api/member/all")
    fun login(): Call<Unit>
}