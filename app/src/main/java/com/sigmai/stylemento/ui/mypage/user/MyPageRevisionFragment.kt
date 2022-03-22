package com.sigmai.stylemento.ui.mypage.user

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageRevisionBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.mypage.user.viewModel.MyPageRevisionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageRevisionFragment : BaseFragment<FragmentMyPageRevisionBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_revision
    private val viewModel: MyPageRevisionViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun initState() {
        viewModel.getUserInfo()
    }
}