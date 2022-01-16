package com.sigmai.stylemento.feature.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.ChattingRoom
import com.sigmai.stylemento.databinding.FragmentChatBinding
import com.sigmai.stylemento.feature.chat.adapter.ChattingRoomListAdapter
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
        recyclerView.adapter = ChattingRoomListAdapter()
    }
}