package com.sigmai.stylemento.domain.entity

import java.util.*

data class Review(
    val rating: Int,
    val nickname: String,
    val profileImageUrl: String?,
    val tall: Int?,
    val weight: Int?,
    val date: Date?,
    val content: String,
    val reply: Reply
)