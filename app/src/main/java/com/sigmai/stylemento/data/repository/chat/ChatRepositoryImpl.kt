package com.sigmai.stylemento.data.repository.chat

import com.sigmai.stylemento.data.model.response.chat.Chat
import com.sigmai.stylemento.data.model.response.chat.ChatRoom
import com.sigmai.stylemento.domain.repository.ChatRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(private val dataSource: ChatDataSource) :
    ChatRepository {
    override fun getChatAll(chatRoomSeq: Long, page: Int, size: Int): List<Chat> {
        return dataSource.getChatAll(chatRoomSeq, page, size)
    }
    override fun getChatCordiRooms(cordiEmail: String): ChatRoom {
        return dataSource.getChatCordiRooms(cordiEmail)
    }
    override fun getChatMemberRooms(memberEmail: String): ChatRoom {
        return dataSource.getChatMemberRooms(memberEmail)
    }
    override fun postChatMembers(
        chatRoomSeq: Long,
        memberEmail: String,
        cordiEmail: String
    ): Boolean {
        return dataSource.postChatMembers(chatRoomSeq, memberEmail, cordiEmail)
    }

    override fun postChatMessage(
        chatRoomId: Long,
        chatType: String,
        senderEmail: String,
        senderId: String,
        message: String,
        imageFile: MultipartBody.Part
    ): Boolean {
        return dataSource.postChatMessage(chatRoomId, chatType, senderEmail, senderId, message, imageFile)
    }

    override fun getChatRoom(chatRoomId: Long): ChatRoom {
        return dataSource.getChatRoom(chatRoomId)
    }
    override fun postChatRoom(clientEmail: String, cordiEmail: String): Boolean {
        return dataSource.postChatRoom(clientEmail, cordiEmail)
    }
}