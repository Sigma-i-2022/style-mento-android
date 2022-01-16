package com.sigmai.stylemento.feature.chat.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Chat
import com.sigmai.stylemento.global.constant.ChatType
import java.lang.IllegalArgumentException

class ChatAdapter(private val chatList: List<Chat>) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    var tempList: List<Chat>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return when(viewType) {
            ChatType.FROM_ME -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_chat_from_me, parent, false)
                ChatFromMeViewHolder(view)
            }
            ChatType.TO_ME -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_chat_to_me, parent, false)
                ChatToMeViewHolder(view)
            }
            else -> throw IllegalArgumentException("UNKNOWN VIEW TYPE")
        }
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        Log.d("tag", "${position} : ${holder}")
        if(holder is ChatFromMeViewHolder) holder.content.text = chatList[position].content
        if(holder is ChatToMeViewHolder) holder.content.text = chatList[position].content
    }

    override fun getItemCount() = chatList.size

    fun setList(items: List<Chat>) {
        tempList = items
    }

    override fun getItemViewType(position: Int): Int {
        return chatList[position].type
    }

    abstract inner class ChatViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        abstract val content: TextView
    }

    inner class ChatFromMeViewHolder(view: View) : ChatViewHolder(view) {
        override val content: TextView = view.findViewById(R.id.chat_from_me)
    }

    inner class ChatToMeViewHolder(view: View) : ChatViewHolder(view) {
        override val content: TextView = view.findViewById(R.id.chat_to_me)
    }
}