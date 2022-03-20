package com.sigmai.stylemento.data.model.response.myPage

data class MyPageClient(
    val email: String,
    val intro: String,
    val profileImageUrl: String,
    val seq: Long,
    val userId: String,
)