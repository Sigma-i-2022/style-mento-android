package com.sigmai.stylemento.data.model.response.review

data class Review(
    val content: String,
    val coordinatorId: String,
    val height: String,
    val registDate: String,
    val reportContent: String,
    val reportReason: String,
    val reportYn: String,
    val reservationSeq: Long,
    val reviewId: String,
    val seq: Long,
    val sex: String,
    val star: Int,
    val weight: String
)