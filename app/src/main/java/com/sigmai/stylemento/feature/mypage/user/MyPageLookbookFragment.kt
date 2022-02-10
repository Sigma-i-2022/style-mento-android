package com.sigmai.stylemento.feature.mypage.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookBinding
import com.sigmai.stylemento.feature.mypage.user.adapter.UserLookbookAdapter
import com.sigmai.stylemento.feature.mypage.user.viewModel.MyPageLookbookViewModel
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageLookbookFragment() : BaseFragment<FragmentMyPageLookbookBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook
    private val viewModel: MyPageLookbookViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startAddLookbook.observe(this) {
            findNavController().navigate(R.id.action_main_to_lookbook_add)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lookbookAdapter = UserLookbookAdapter(this)
        val gridLayoutManager = GridLayoutManager(context,3, GridLayoutManager.VERTICAL, false)

        binding.myPageUserLookbookRecycler.adapter = lookbookAdapter
        binding.myPageUserLookbookRecycler.layoutManager = gridLayoutManager

    }
}