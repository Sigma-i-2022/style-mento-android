package com.sigmai.stylemento.data.model

data class Receipt(
    val coordinator : Coordinator,
    val user : User,
    val serviceName : String,
    val serviceWay : String,
    val price : Int,
    val date : String,
    val time : String
)