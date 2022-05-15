package com.sigmai.stylemento.ui.mypage.coordinator

import android.annotation.SuppressLint
import androidx.fragment.app.activityViewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageReviewBinding
import com.sigmai.stylemento.ui.mypage.adapter.CoordinatorReviewAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageReviewFragment() : BaseFragment<FragmentMyPageReviewBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_review
    val viewModel: CoordinatorPageViewModel by activityViewModels()

    override fun initState() {
        binding.myPageReviewRecycler.adapter = CoordinatorReviewAdapter(this)
        viewModel.fetchReviews()
    }
}