package com.sigmai.stylemento.domain.entity

data class Receipt(
    val coordinator : Coordinator,
    val user : User,
    val serviceName : String,
    val serviceWay : String,
    val price : Int,
    val date : String,
    val timeList : List<String>,
    val paymentWay : String,
    val requestTime : String,
    val decidedTime : String,
    val state : Int
)