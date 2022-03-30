package com.sigmai.stylemento.data.model

data class PaymentCard(
    val acquireStatus : String,
    var approveNo : String,
    var cardType : String,
    var company : String,
    var installmentPlanMonths : String,
    var isInterestFree : String,
    var number : String,
    var ownerType : String,
    var receiptUrl : String,
    var useCardPoint : String,
)