package com.sigmai.stylemento.data.model.response.cancel

data class CancelItem(
    val byWho: String,
    val reason: String,
    val reservationSeq: Long
)