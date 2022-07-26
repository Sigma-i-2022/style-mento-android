package com.sigmai.stylemento.domain.entity

data class Review(
    val seq: Long,
    val rating: Float,
    val nickname: String,
    val profileImageUrl: String? = null,
    val tall: String? = null,
    val weight: String? = null,
    val date: String? = null,
    val content: String,
    val replySeq: Long?,
    val reply: String? = null,
    val hasReply: Boolean,
    val deleteEvent: ((Long)->Unit)? = null,
    val postEvent: ((Long, String)->Unit)? = null
)