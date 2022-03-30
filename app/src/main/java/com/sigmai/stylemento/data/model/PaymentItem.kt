package com.sigmai.stylemento.data.model

data class PaymentItem(
    val amount : Long,
    val cancelYn : String,
    val cardCompany : String,
    val cardNumber : String,
    val cardReceiptUrl : String,
    val createDate : String,
    val customerEmail : String,
    val customerName : String,
    val orderId : String,
    val orderName : String,
    val payFailReason : String,
    val paySuccessYn : String,
    val payType : String,
    val paymentKey : String,
    val reservationSeq : Long,
    val seq : Long
)