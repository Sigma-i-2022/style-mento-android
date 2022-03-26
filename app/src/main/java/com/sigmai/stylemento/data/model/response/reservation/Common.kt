package com.sigmai.stylemento.data.model.response.reservation

data class Common (
    val cancelYn : String,
    val clientId : String,
    val confirmPayYn : String,
    val confirmResvYn : String,
    val confirmReserveYn : String,
    val crdiId : String,
    val price : Int,
    val requestReservationTime : String,
    val requireText : String,
    val reserveDay : String,
    val reserveTimes : String,
    val reviewedYn : String,
    val seq : Int,
    val serviceSystem : String,
    val serviceType : String
)