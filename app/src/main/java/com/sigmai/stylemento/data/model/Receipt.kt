package com.sigmai.stylemento.data.model

data class Receipt(
    val coordinator : Coordinator,
    val user : User,
    var serviceName : String = "",
    var serviceWay : String = "",
    var price : Int = 0,
    var date : String = "",
    var time : List<String> = listOf(),
    var paymentWay : String = ""
)