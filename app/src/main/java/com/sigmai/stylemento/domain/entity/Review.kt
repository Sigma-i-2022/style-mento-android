package com.sigmai.stylemento.domain.entity

data class Review(
    val rating: Float,
    val nickname: String,
    val profileImageUrl: String? = null,
    val tall: Int? = null,
    val weight: Int? = null,
    val date: String? = null,
    val content: String,
    val reply: String? = null,
    val hasReply: Boolean
)