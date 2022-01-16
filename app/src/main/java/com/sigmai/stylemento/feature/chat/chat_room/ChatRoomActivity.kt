package com.sigmai.stylemento.feature.chat.chat_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ActivityChatRoomBinding
import com.sigmai.stylemento.feature.chat.adapter.ChatAdapter

class ChatRoomActivity : AppCompatActivity() {
    val viewModel: ChatRoomViewModel by viewModels()
    private lateinit var binding: ActivityChatRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat_room)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val recyclerView = findViewById<RecyclerView>(R.id.chatting_list)
        recyclerView.adapter = ChatAdapter()
    }
}