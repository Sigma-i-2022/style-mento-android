package com.sigmai.stylemento.data.model

data class Payment(
    val amount : Long,
    val cashReceiptType : String,
    val createDate : String,
    val customerEmail : String,
    val customerName : String,
    val failUrl : String,
    val orderId : String,
    val orderName : String,
    val paySuccessYn : String,
    val payType : String,
    val reservationSeq : String,
    val successUrl : String,
    val userEscrow : Boolean,
    val validHours : Long
)