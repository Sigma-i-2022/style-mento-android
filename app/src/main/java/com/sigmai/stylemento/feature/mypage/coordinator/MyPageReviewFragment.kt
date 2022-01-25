package com.sigmai.stylemento.feature.mypage.coordinator

import android.os.Bundle
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.databinding.FragmentMyPageReviewBinding
import com.sigmai.stylemento.feature.mypage.coordinator.adapter.CoordinatorReviewAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageReviewFragment : BaseFragment<FragmentMyPageReviewBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_review

    private val reviewAdapter = CoordinatorReviewAdapter(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reviewAdapter.setList(Client.getCoordinatorInfo().reviews)
        binding.myPageReviewRecycler.adapter = reviewAdapter
    }

    fun updateAdapter(){
        reviewAdapter.setList(Client.getCoordinatorInfo().reviews)
        binding.myPageReviewRecycler.adapter = reviewAdapter
    }
}