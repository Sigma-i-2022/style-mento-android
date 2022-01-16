package com.sigmai.stylemento.feature.chat.chat_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Chat
import com.sigmai.stylemento.feature.chat.adapter.ChatAdapter
import com.sigmai.stylemento.global.base.BaseActivity
import com.sigmai.stylemento.global.constant.ChatType

class ChatRoomActivity : BaseActivity() {
    override val layoutResourceId = R.layout.activity_chat_room

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.chatting_list)
        recyclerView.adapter = ChatAdapter()
    }
}