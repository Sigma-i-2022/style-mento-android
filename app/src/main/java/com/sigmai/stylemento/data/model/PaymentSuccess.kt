package com.sigmai.stylemento.data.model

data class PaymentSuccess(
    val approvedAt : String,
    val balanceAmount : String,
    val cancels : List<PaymentCancel>,
    val card : PaymentCard,
    val cultureExpense : String,
    val currency : String,
    val method : String,
    val mid : String,
    val orderId : String,
    val orderName : String,
    val paymentKey : String,
    val requestedAt : String,
    val secret : String,
    val status : String,
    val suppliedAmount : String,
    val totalAmount : String,
    val type : String,
    val useEscrow : String,
    val vat : String,
    val version : String,
    val virtualAccount : PaymentVirtualAccount
)