package com.sigmai.stylemento.data.model

data class PaymentFail(
    val errorCode : String,
    val errorMsg : String,
    val orderId : String,
)