package com.sigmai.stylemento.data.repository.chat

import com.sigmai.stylemento.data.api.ChatService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.chat.Chat
import com.sigmai.stylemento.data.model.response.chat.ChatRoom
import okhttp3.MultipartBody
import javax.inject.Inject

class ChatDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<ChatService>()

    fun getChatAll(chatRoomSeq: Long, page: Int, size: Int) : List<Chat>{
        return service.getChatAll(chatRoomSeq, page, size).execute().body()!!.data
    }

    fun getChatCordiRooms(cordiEmail: String) : ChatRoom{
        return service.getChatCordiRooms(cordiEmail).execute().body()!!.data
    }

    fun getChatMemberRooms(memberEmail: String) : ChatRoom{
        return service.getChatMemberRooms(memberEmail).execute().body()!!.data
    }

    fun postChatMembers(chatRoomSeq: Long, memberEmail: String, cordiEmail: String) : Boolean{
        return service.postChatMembers(chatRoomSeq, memberEmail, cordiEmail).execute().body()?.success ?: false
    }

    fun postChatMessage(chatRoomId: Long, chatType: String, senderEmail: String, senderId: String, message: String, imageFile: MultipartBody.Part) : Boolean {
        return service.postChatMessage(chatRoomId, chatType, senderEmail, senderId, message, imageFile).execute().body()?.success ?: false
    }

    fun getChatRoom(chatRoomId: Long) : ChatRoom{
        return service.getChatRoom(chatRoomId).execute().body()!!.data
    }

    fun postChatRoom(clientEmail: String, cordiEmail: String) : Boolean{
        return service.postChatRoom(clientEmail, cordiEmail).execute().body()?.success ?: false
    }
}