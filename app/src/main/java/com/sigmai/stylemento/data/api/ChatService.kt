package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.chat.Chat
import com.sigmai.stylemento.data.model.response.chat.ChatRoom
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*
import java.io.File

interface ChatService {
    @GET("v1/api/chat/all")
    fun getChatAll(
        @Query("chatRoomSeq") chatRoomSeq: Long,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Call<ResponseWrapper<Chat>>

    @GET("v1/api/chat/cordi/rooms")
    fun getChatCordiRooms(
        @Query("cordiEmail") cordiEmail: String
    ): Call<ResponseWrapper<ChatRoom>>

    @GET("v1/api/chat/member/rooms")
    fun getChatMemberRooms(
        @Query("memberEmail") memberEmail: String
    ): Call<ResponseWrapper<ChatRoom>>

    @POST("v1/api/chat/members/{chatRoomSeq}}") //경로 이름??
    fun postChatMembers(
        @Path("chatRoomSeq") chatRoomSeq: Long,
        @Query("memberEmail") memberEmail: String,
        @Query("cordiEmail") cordiEmail: String
    ): Call<ResponseWrapper<Unit>>

    @POST("v1/api/chat/message")
    fun postChatMessage(
        @Query("chatRoomId") chatRoomId: Long,
        @Query("chatType") chatType: String,
        @Query("senderEmail") senderEmail: String,
        @Query("senderId") senderId: String,
        @Query("message") message: String,
        @Part imageFile: MultipartBody.Part
    ): Call<ResponseWrapper<Unit>>

    @GET("v1/api/chat/room")
    fun getChatRoom(
        @Query("chatRoomId") chatRoomId: Long
    ): Call<ResponseWrapper<ChatRoom>>

    @POST("v1/api/chat/room")
    fun postChatRoom(
        @Query("clientEmail") clientEmail: String,
        @Query("cordiEmail") cordiEmail: String
    ): Call<ResponseWrapper<Unit>>
}