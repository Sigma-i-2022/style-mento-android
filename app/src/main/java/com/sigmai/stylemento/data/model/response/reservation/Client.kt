package com.sigmai.stylemento.data.model.response.reservation

data class Client (
    val clientEmail : String,
    val crdiEmail : String,
    val requireText : String,
    val reserveDay : String,
    val reserveTimes : List<String>,
    val serviceSystem : String,
    val serviceType : String
)