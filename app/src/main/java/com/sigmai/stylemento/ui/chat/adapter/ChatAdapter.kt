package com.sigmai.stylemento.ui.chat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.Chat
import com.sigmai.stylemento.databinding.ItemChatFromMeBinding
import com.sigmai.stylemento.databinding.ItemChatToMeBinding
import com.sigmai.stylemento.global.constant.ChatType
import java.lang.IllegalArgumentException

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    var chatList: List<Chat>? = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return when(viewType) {
            ChatType.FROM_ME -> ChatFromMeViewHolder.from(parent)
            ChatType.TO_ME -> ChatToMeViewHolder.from(parent)
            else -> throw IllegalArgumentException("UNKNOWN VIEW TYPE")
        }
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val item = chatList!![position]

        if(holder is ChatFromMeViewHolder) holder.bind(item)
        if(holder is ChatToMeViewHolder) holder.bind(item)
    }

    override fun getItemCount() = chatList!!.size

    override fun getItemViewType(position: Int): Int {
        return chatList!![position].type
    }

    fun setList(items: List<Chat>) {
        chatList = items
    }

    abstract class ChatViewHolder protected constructor(val view: View) : RecyclerView.ViewHolder(view)

    class ChatFromMeViewHolder(val binding: ItemChatFromMeBinding) : ChatViewHolder(binding.root) {
        fun bind(item: Chat) {
            binding.item = item
        }

        companion object {
            fun from(parent: ViewGroup) : ChatViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemChatFromMeBinding.inflate(layoutInflater, parent, false)

                return ChatFromMeViewHolder(binding)
            }
        }
    }

    class ChatToMeViewHolder(val binding: ItemChatToMeBinding) : ChatViewHolder(binding.root) {
        fun bind(item: Chat) {
            binding.item = item
        }

        companion object {
            fun from(parent: ViewGroup) : ChatViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemChatToMeBinding.inflate(layoutInflater, parent, false)

                return ChatToMeViewHolder(binding)
            }
        }
    }
}