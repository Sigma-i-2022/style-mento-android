package com.sigmai.stylemento.data.model

data class PaymentCancel(
    val cancelAmount : Long,
    val cancelReason : String,
    val canceledAt : String,
    val refundableAmount : Long,
    val taxAmount : Long,
    val taxFreeAmount : Long
)