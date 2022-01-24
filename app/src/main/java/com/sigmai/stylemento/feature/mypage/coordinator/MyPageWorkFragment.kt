package com.sigmai.stylemento.feature.mypage.coordinator

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookBinding
import com.sigmai.stylemento.databinding.FragmentMyPageWorkBinding
import com.sigmai.stylemento.feature.mypage.coordinator.adapter.CoordinatorWorkAdapter
import com.sigmai.stylemento.feature.mypage.user.adapter.UserLookbookAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageWorkFragment : BaseFragment<FragmentMyPageWorkBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_work

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val workAdapter = CoordinatorWorkAdapter(this)
        val gridLayoutManager = GridLayoutManager(context,3, GridLayoutManager.VERTICAL, false)

        workAdapter.setDataSet(Client.getCoordinatorInfo().workItems)
        binding.myPageWorkRecycler.adapter = workAdapter
        binding.myPageWorkRecycler.layoutManager = gridLayoutManager

        binding.myPageWorkAddImg.setOnClickListener(View.OnClickListener {
            val transaction = parentFragment?.parentFragmentManager?.beginTransaction()
            transaction?.replace(R.id.my_page_frameLayout, MyPageWorkAddFragment())
            transaction?.commit()
        })
    }
}