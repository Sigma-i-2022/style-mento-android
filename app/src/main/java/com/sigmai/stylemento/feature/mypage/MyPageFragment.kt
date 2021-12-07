package com.sigmai.stylemento.feature.mypage

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageBinding
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageFragment : BaseFragment<FragmentMyPageBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page
    private val viewModel: MyPageViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }
}