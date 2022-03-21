package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.response.chat.Chat
import com.sigmai.stylemento.data.model.response.chat.ChatRoom
import okhttp3.MultipartBody

interface ChatRepository {
    fun getChatAll(chatRoomSeq: Long, page: Int, size: Int) : List<Chat>
    fun getChatCordiRooms(cordiEmail: String) : ChatRoom
    fun getChatMemberRooms(memberEmail: String) : ChatRoom
    fun postChatMembers(chatRoomSeq: Long, memberEmail: String, cordiEmail: String) : Boolean
    fun postChatMessage(chatRoomId: Long, chatType: String, senderEmail: String, senderId: String, message: String, imageFile: MultipartBody.Part) : Boolean
    fun getChatRoom(chatRoomId: Long) : ChatRoom
    fun postChatRoom(clientEmail: String, cordiEmail: String) : Boolean
}