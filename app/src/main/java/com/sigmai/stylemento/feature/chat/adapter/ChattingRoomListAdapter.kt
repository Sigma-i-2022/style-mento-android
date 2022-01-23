package com.sigmai.stylemento.feature.chat.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.ChattingRoom
import com.sigmai.stylemento.databinding.ItemChatListBinding
import com.sigmai.stylemento.feature.chat.chat_room.ChatRoomActivity

class ChattingRoomListAdapter : RecyclerView.Adapter<ChattingRoomListAdapter.ChattingRoomViewHolder>() {
    private var chattingRooms: List<ChattingRoom>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChattingRoomViewHolder {
        return ChattingRoomViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ChattingRoomViewHolder, position: Int) {
        holder.bind(chattingRooms!![position])
    }

    override fun getItemCount() = chattingRooms?.size ?: 0

    fun setList(items: List<ChattingRoom>) {
        chattingRooms = items
    }

    class ChattingRoomViewHolder private constructor(val binding: ItemChatListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ChattingRoom) {
            binding.item = item

            binding.root.setOnClickListener {
                binding.root.findNavController().navigate(R.id.action_main_to_chat_room)
            }
        }

        companion object {
            fun from(parent: ViewGroup) : ChattingRoomViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemChatListBinding.inflate(layoutInflater, parent, false)

                return ChattingRoomViewHolder(binding)
            }
        }
    }
}