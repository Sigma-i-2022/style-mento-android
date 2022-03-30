package com.sigmai.stylemento.data.model.response.cancel

data class CancelItem(
    val approvedAt: String,
    val cancelAmount: Int,
    val cancelDate: String,
    val cancelReason: String,
    val cardCompany: String,
    val cardNumber: String,
    val orderId: String,
    val orderName: String,
    val paymentKey: String,
    val receiptUrl: String,
    val requestedAt: String,
    val seq: Long
)