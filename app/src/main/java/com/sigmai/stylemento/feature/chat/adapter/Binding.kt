package com.sigmai.stylemento.feature.chat.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.Chat
import com.sigmai.stylemento.data.model.ChattingRoom

@BindingAdapter("app:chats")
fun setChats(listView: RecyclerView, items: List<Chat>) {
    (listView.adapter as ChatAdapter).setList(items)
}

@BindingAdapter("app:chattingRooms")
fun setRooms(listView: RecyclerView, items: List<ChattingRoom>) {
    (listView.adapter as ChattingRoomListAdapter).setList(items)
}