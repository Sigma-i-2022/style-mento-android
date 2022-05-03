package com.sigmai.stylemento.data.model.response.reservation

data class Common (
    val cancelYn : String,
    val clientEmail : String,
    val clientId : String,
    val confirmPayYn : String,
    val confirmResvYn : String,
    val confirmReserveTime : String,
    val crdiEmail : String,
    val crdiId : String,
    val payYn : String,
    val price : Int,
    val requestReservationTime : String,
    val requireText : String,
    val reserveDay : String,
    val reserveTimes : List<String>,
    val reviewedYn : String,
    val seq : Long,
    val serviceSystem : String,
    val serviceType : String
)