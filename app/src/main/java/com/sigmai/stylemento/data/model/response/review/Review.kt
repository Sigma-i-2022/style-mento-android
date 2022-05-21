package com.sigmai.stylemento.data.model.response.review

import com.sigmai.stylemento.domain.entity.Review

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
    val height: Int,
    val weight: Int,
    val replyRes: ReplyResponse
) {
    fun toEntity() : Review {
        return Review(
            seq = seq,
            rating = star.toFloat(),
            nickname = reviewerId,
            profileImageUrl = null,
            tall = height,
            weight = weight,
            date = registDate,
            content = content,
            reply = replyRes.replyContent,
            hasReply = !replyRes.replyContent.isNullOrEmpty(),
            replySeq = replyRes.seq
        )
    }
}

data class ReplyResponse(
    val crdiEmail: String,
    val replyContent: String,
    val reviewSeq: String,
    val seq: Long
)