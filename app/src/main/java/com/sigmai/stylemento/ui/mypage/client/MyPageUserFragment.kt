package com.sigmai.stylemento.ui.mypage.client

import android.view.View
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageUserBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.mypage.client.adapter.PieceGridAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageUserFragment : BaseFragment<FragmentMyPageUserBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_user
    private val viewModel: MyPageUserViewModel by viewModels()

    override fun initState() {
        super.initState()
        viewModel.getUserInfo()

        setupButtons()
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
        binding.myPageUserChatButton.visibility = View.GONE
        binding.lookbookRecyclerview.adapter = PieceGridAdapter()

    }

    private fun setupButtons() {
        binding.toolbar.setOnEditListener {
            viewModel.onRevisionClick(it)
        }
        binding.toolbar.setOnSettingsListener {

        }
    }
}