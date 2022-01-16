package com.sigmai.stylemento.feature.chat

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.ChattingRoom

class ChatViewModel : ViewModel() {
    val chattingRoomList = listOf(
        ChattingRoom("user_name1", "안녕하세요1"),
        ChattingRoom("user_name2", "안녕하세요2"),
        ChattingRoom("user_name3", "안녕하세요3"),
        ChattingRoom("user_name4", "안녕하세요4"),
        ChattingRoom("user_name5", "안녕하세요5"),
        ChattingRoom("user_name8", "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요")
    )
}