package com.sigmai.stylemento.ui.mypage.user

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookItemBinding
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookScrollBinding
import com.sigmai.stylemento.domain.usecase.GetLookbookItemUseCase
import com.sigmai.stylemento.ui.mypage.TagAdapter
import com.sigmai.stylemento.ui.mypage.user.viewModel.MyPageLookbookItemViewModel
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.mypage.user.adapter.UserLookbookAdapter
import com.sigmai.stylemento.ui.mypage.user.adapter.UserLookbookItemAdapter
import com.sigmai.stylemento.ui.mypage.user.viewModel.MyPageLookbookScrollViewModel

class MyPageLookbookScrollFragment() : BaseFragment<FragmentMyPageLookbookScrollBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook_scroll
    private val viewModel: MyPageLookbookScrollViewModel by viewModels()

    private var position = 0
    override fun initState() {
        super.initState()
        position = arguments?.getInt("position")!!
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this, {
            findNavController().navigateUp()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lookbookTagAdapter = UserLookbookItemAdapter()
        binding.myPageUserLookbookScrollRecycler.adapter = lookbookTagAdapter
        binding.myPageUserLookbookScrollRecycler.scrollToPosition(position)
    }
}