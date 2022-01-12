package com.sigmai.stylemento.feature.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Chat
import com.sigmai.stylemento.databinding.FragmentChatBinding
import com.sigmai.stylemento.feature.chat.adapter.ChatListAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class ChatFragment :BaseFragment<FragmentChatBinding>() {
    override val layoutResourceId = R.layout.fragment_chat
    private val viewModel: ChatViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.chat_list_recyclerview)
        recyclerView.adapter = ChatListAdapter(
            listOf(
                Chat("user_name1", "안녕하세요1"),
                Chat("user_name2", "안녕하세요2"),
                Chat("user_name3", "안녕하세요3"),
                Chat("user_name4", "안녕하세요4"),
                Chat("user_name5", "안녕하세요5"),
                Chat("user_name6", "안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요")
            )
        )
    }
}