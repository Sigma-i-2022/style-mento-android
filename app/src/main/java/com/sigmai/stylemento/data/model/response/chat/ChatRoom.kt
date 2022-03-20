package com.sigmai.stylemento.data.model.response.chat

data class ChatRoom(
    val clientId: String,
    val clientProfileImageUrl: String,
    val cordiId: String,
    val cordiProfileImageUrl: String,
    val initYn: String,
    val regDate: String,
    val roomSeq: Long
)