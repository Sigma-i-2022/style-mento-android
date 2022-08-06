package com.sigmai.stylemento.data.model

data class Receipt(
    val coordinator : Coordinator,
    var serviceName : String = "",
    var serviceWay : String = "",
    var price : Int = 0,
    var date : String = "",
    var timeList : List<String> = listOf(),
    var paymentWay : String = "",
    var time : String = "",
    var state : Int = 0
)