package com.sigmai.stylemento.domain.entity

data class Review(
    val seq: Long,
    val rating: Float,
    val nickname: String,
    val profileImageUrl: String? = null,
    val tall: Int? = null,
    val weight: Int? = null,
    val date: String? = null,
    val content: String,
    val replySeq: Long?,
    val reply: String? = null,
    val hasReply: Boolean,
    val deleteEvent: ((Long)->Unit)? = null,
    val postEvent: ((Long)->Unit)? = null
)