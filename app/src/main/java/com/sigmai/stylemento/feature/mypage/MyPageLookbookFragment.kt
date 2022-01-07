package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageClosetBinding
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookBinding
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageLookbookFragment : BaseFragment<FragmentMyPageLookbookBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook

    val testDataSet = arrayOf("1", "2", "3", "4", "5")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lookbookRecyclerView : RecyclerView = view.findViewById(R.id.user_lookbook_recycler)
        val lookbookAdapter = UserLookbookAdapter(testDataSet)
        val gridLayoutManager = GridLayoutManager(context,3, GridLayoutManager.VERTICAL, false)

        //gridLayoutManager.orientation = LinearLayoutManager.VERTICAL
        lookbookRecyclerView.adapter = lookbookAdapter
        lookbookRecyclerView.layoutManager = gridLayoutManager


    }
}