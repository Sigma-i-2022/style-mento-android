package com.sigmai.stylemento.ui.mypage.coordinator

import androidx.fragment.app.activityViewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageReviewBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.mypage.adapter.CoordinatorReviewAdapter

class MyPageReviewFragment : BaseFragment<FragmentMyPageReviewBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_review
    val viewModel: CoordinatorPageViewModel by activityViewModels()

    override fun initDataBinding() {
        binding.viewModel = viewModel
    }

    override fun initState() {
        binding.myPageReviewRecycler.adapter = CoordinatorReviewAdapter(this)
        viewModel.fetchReviews()
    }
}