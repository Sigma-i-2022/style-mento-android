package com.sigmai.stylemento.feature.mypage.coordinator

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookBinding
import com.sigmai.stylemento.databinding.FragmentMyPageReviewBinding
import com.sigmai.stylemento.databinding.FragmentMyPageWorkBinding
import com.sigmai.stylemento.feature.mypage.user.adapter.UserLookbookAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageReviewFragment : BaseFragment<FragmentMyPageReviewBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_review

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val lookbookAdapter = UserLookbookAdapter(this)
        val gridLayoutManager = GridLayoutManager(context,3, GridLayoutManager.VERTICAL, false)

        lookbookAdapter.setDataSet(Client.getUserInfo().lookbookItems)
        binding.myPageUserLookbookRecycler.adapter = lookbookAdapter
        binding.myPageUserLookbookRecycler.layoutManager = gridLayoutManager

        binding.myPageUserLookbookAddImg.setOnClickListener(View.OnClickListener {
            val transaction = parentFragment?.parentFragmentManager?.beginTransaction()
            transaction?.replace(R.id.my_page_frameLayout, MyPageLookbookAddFragment())
            transaction?.commit()
        })*/
    }
}