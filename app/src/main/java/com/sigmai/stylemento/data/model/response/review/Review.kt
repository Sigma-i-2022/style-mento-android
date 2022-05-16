package com.sigmai.stylemento.data.model.response.review

data class Review(
    val seq: Long,
    val reservationSeq: Long,
    val reviewerId: String,
    val coordinatorId: String,
    val star: Int,
    val sex: String,
    val content: String,
    val reportYn: String,
    val registDate: String,
    val reportContent: String,
    val reportReason: String,
    val height: String,
    val weight: String,
    val replyRes: ReplyResponse
)

data class ReplyResponse(
    val crdiEmail: String,
    val replyContent: String,
    val reviewSeq: String,
    val seq: Long
)