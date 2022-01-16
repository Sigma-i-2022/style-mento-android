package com.sigmai.stylemento.feature.chat.chat_room

import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.data.model.Chat
import com.sigmai.stylemento.global.constant.ChatType

class ChatRoomViewModel : ViewModel() {
    val dummyList = listOf(
        Chat("아무말1", ChatType.FROM_ME),
        Chat("아무말2", ChatType.FROM_ME),
        Chat("아무말3", ChatType.TO_ME),
        Chat("아무말4", ChatType.FROM_ME),
        Chat("아무말8", ChatType.TO_ME),
    )
}