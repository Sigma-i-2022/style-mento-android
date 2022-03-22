package com.sigmai.stylemento.ui.mypage.user

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageUserBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.mypage.user.adapter.UserLookbookAdapter
import com.sigmai.stylemento.ui.mypage.user.viewModel.MyPageUserViewModel

class MyPageUserFragment : BaseFragment<FragmentMyPageUserBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_user
    private val viewModel: MyPageUserViewModel by viewModels()

    private var introductionState = 0

    override fun initState() {
        super.initState()
        viewModel.getUserInfo()
    }
    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startRevision.observe(this) {
            findNavController().navigate(R.id.action_main_to_user_revision)
        }
        viewModel.startInstruction.observe(this) {
            if (introductionState == 0) {
                binding.myPageUserIntroductionText.maxLines = 10
                introductionState = 1
            } else {
                binding.myPageUserIntroductionText.maxLines = 3
                introductionState = 0
            }
        }
        binding.myPageUserChatButton.visibility = View.GONE
        binding.lookbookRecyclerview.adapter = UserLookbookAdapter()
    }
}