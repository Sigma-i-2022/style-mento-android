package com.sigmai.stylemento.feature.chat.chat_room

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentChatRoomBinding
import com.sigmai.stylemento.global.base.BaseFragment

class CharRoomFragment : BaseFragment<FragmentChatRoomBinding>() {
    override val layoutResourceId = R.layout.fragment_chat_room
    private val viewModel: ChatRoomViewModel by viewModels()

    override fun initDataBinding() {
        binding.viewModel = viewModel
    }
}