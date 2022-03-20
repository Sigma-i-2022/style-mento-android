package com.sigmai.stylemento.data.model.response.chat

data class Chat(
    val chatRoomId: Long,
    val chatType: String,
    val imagePathUrl: String,
    val message: String,
    val regDate: String,
    val senderId: String,
    val senderProfileImgUrl: String
)