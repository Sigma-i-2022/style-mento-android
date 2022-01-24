package com.sigmai.stylemento.feature.mypage.coordinator

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookBinding
import com.sigmai.stylemento.databinding.FragmentMyPageReviewBinding
import com.sigmai.stylemento.databinding.FragmentMyPageWorkBinding
import com.sigmai.stylemento.feature.mypage.coordinator.adapter.ReviewAdapter
import com.sigmai.stylemento.feature.mypage.user.adapter.UserLookbookAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageReviewFragment : BaseFragment<FragmentMyPageReviewBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_review

    private val reviewAdapter = ReviewAdapter(this)
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