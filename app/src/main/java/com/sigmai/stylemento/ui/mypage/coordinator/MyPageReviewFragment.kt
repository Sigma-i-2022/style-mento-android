package com.sigmai.stylemento.ui.mypage.coordinator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.databinding.FragmentMyPageReviewBinding
import com.sigmai.stylemento.ui.mypage.coordinator.adapter.CoordinatorReviewAdapter
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.coordinator.CoordinatorPageViewModel

class MyPageReviewFragment() : BaseFragment<FragmentMyPageReviewBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_review
    val viewModel: CoordinatorPageViewModel by activityViewModels()

    override fun initState() {
        binding.myPageReviewRecycler.adapter = CoordinatorReviewAdapter(this)
        setupObserver()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupObserver() {
        viewModel.coordinator.observe(this) {
            binding.myPageReviewRecycler.adapter!!.notifyDataSetChanged()
        }
    }
}