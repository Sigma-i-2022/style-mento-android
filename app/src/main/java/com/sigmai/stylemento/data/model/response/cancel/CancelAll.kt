package com.sigmai.stylemento.data.model.response.cancel

data class CancelAll(
    val byWho: String,
    val reason: String,
    val reservationSeq: Long
)