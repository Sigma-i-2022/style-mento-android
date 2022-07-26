package com.sigmai.stylemento.data.model.response.review

import com.sigmai.stylemento.domain.entity.Review

data class Review(
    val seq: Long,
    val reservationSeq: Long,
    val reviewerId: String,
    val reviewerProfileImagerUrl: String,
    val coordinatorId: String,
    val star: Int,
    val sex: String,
    val content: String,
    val reportYn: String,
    val registDate: String,
    val reportContent: String?,
    val reportReason: String?,
    val height: String,
    val weight: String,
    val replyRes: ReplyResponse?
) {
    fun toEntity() : Review {
        return Review(
            seq = seq,
            rating = star.toFloat(),
            nickname = reviewerId,
            profileImageUrl = reviewerProfileImagerUrl,
            tall = height,
            weight = weight,
            date = registDate,
            content = content,
            reply = replyRes?.replyContent,
            hasReply = replyRes != null,
            replySeq = replyRes?.seq
        )
    }
}

data class ReplyResponse(
    val crdiEmail: String,
    val replyContent: String,
    val reviewSeq: String,
    val seq: Long
)