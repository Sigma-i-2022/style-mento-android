package com.sigmai.stylemento.feature.chat.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Chat
import com.sigmai.stylemento.feature.chat.chat_room.ChatRoomActivity

class ChatListAdapter(val chatList : List<Chat>) : RecyclerView.Adapter<ChatListAdapter.ChatListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_list, parent, false)

        return ChatListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {
        holder.name.text = chatList[position].name
        holder.summary.text = chatList[position].summary
    }

    override fun getItemCount() = chatList.size

    inner class ChatListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.chat_list_name)
        val summary: TextView = view.findViewById(R.id.chat_list_summary)

        init {
            view.setOnClickListener {
                val intent = Intent(view.context, ChatRoomActivity::class.java)
                view.context.startActivity(intent)
            }
        }
    }
}