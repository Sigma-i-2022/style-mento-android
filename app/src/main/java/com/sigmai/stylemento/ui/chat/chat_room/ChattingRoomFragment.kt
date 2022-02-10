package com.sigmai.stylemento.ui.chat

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentChatRoomBinding
import com.sigmai.stylemento.ui.chat.adapter.ChatAdapter
import com.sigmai.stylemento.ui.chat.chat_room.ChatRoomViewModel
import com.sigmai.stylemento.global.base.BaseFragment

class ChattingRoomFragment : BaseFragment<FragmentChatRoomBinding>() {
    override val layoutResourceId = R.layout.fragment_chat_room
    private val viewModel: ChatRoomViewModel by viewModels()

    override fun initDataBinding() {
        binding.viewModel = viewModel

        binding.chattingList.adapter = ChatAdapter()
    }
}