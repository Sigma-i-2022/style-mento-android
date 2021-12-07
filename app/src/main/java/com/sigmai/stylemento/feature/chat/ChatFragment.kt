package com.sigmai.stylemento.feature.chat

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentChatBinding
import com.sigmai.stylemento.global.base.BaseFragment

class ChatFragment :BaseFragment<FragmentChatBinding>() {
    override val layoutResourceId = R.layout.fragment_chat
    private val viewModel: ChatViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }
}