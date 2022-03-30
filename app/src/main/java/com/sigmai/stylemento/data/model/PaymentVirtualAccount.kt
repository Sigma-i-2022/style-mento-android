package com.sigmai.stylemento.data.model

data class PaymentVirtualAccount(
    val accountNumber : String,
    val accountType : String,
    val bank : String,
    val customerName : String,
    val dueDate : String,
    val expired : Boolean,
    val refundStatus : String,
    val settlementStatus : String
)