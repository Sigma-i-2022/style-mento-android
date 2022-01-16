package com.sigmai.stylemento.feature.chat.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Chat
import com.sigmai.stylemento.databinding.ItemChatFromMeBinding
import com.sigmai.stylemento.databinding.ItemChatToMeBinding
import com.sigmai.stylemento.global.constant.ChatType
import java.lang.IllegalArgumentException

class ChatAdapter(private val chatList: List<Chat>) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    var tempList: List<Chat>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return when(viewType) {
            ChatType.FROM_ME -> ChatFromMeViewHolder.from(parent)
            ChatType.TO_ME -> ChatToMeViewHolder.from(parent)
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

    abstract class ChatViewHolder protected constructor(val view: View) : RecyclerView.ViewHolder(view) {
        abstract val content: TextView
    }

    class ChatFromMeViewHolder(view: View) : ChatViewHolder(view) {
        override val content: TextView = view.findViewById(R.id.chat_from_me)

        companion object {
            fun from(parent: ViewGroup) : ChatViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemChatFromMeBinding.inflate(layoutInflater, parent, false)

                return ChatFromMeViewHolder(binding.root)
            }
        }
    }

    class ChatToMeViewHolder(view: View) : ChatViewHolder(view) {
        override val content: TextView = view.findViewById(R.id.chat_to_me)

        companion object {
            fun from(parent: ViewGroup) : ChatViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemChatToMeBinding.inflate(layoutInflater, parent, false)

                return ChatToMeViewHolder(binding.root)
            }
        }
    }
}