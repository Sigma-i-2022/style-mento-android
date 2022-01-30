package com.sigmai.stylemento.feature.mypage.coordinator

import android.os.Bundle
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.databinding.FragmentMyPageReviewBinding
import com.sigmai.stylemento.feature.mypage.coordinator.adapter.CoordinatorReviewAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageReviewFragment(private val owner : Coordinator) : BaseFragment<FragmentMyPageReviewBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_review

    private val reviewAdapter = CoordinatorReviewAdapter(this, owner)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reviewAdapter.setList(owner.reviews)
        binding.myPageReviewRecycler.adapter = reviewAdapter
    }
}