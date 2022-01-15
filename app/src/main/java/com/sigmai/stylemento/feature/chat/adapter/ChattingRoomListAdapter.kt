package com.sigmai.stylemento.feature.chat.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.ChattingRoom
import com.sigmai.stylemento.feature.chat.chat_room.ChatRoomActivity

class ChattingRoomListAdapter(val chattingRoomList : List<ChattingRoom>) : RecyclerView.Adapter<ChattingRoomListAdapter.ChattingRoomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChattingRoomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_list, parent, false)

        return ChattingRoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChattingRoomViewHolder, position: Int) {
        holder.name.text = chattingRoomList[position].name
        holder.summary.text = chattingRoomList[position].summary
    }

    override fun getItemCount() = chattingRoomList.size

    inner class ChattingRoomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
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