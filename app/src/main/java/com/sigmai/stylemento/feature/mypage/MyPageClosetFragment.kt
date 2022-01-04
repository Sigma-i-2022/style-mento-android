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
import androidx.viewpager2.widget.ViewPager2
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageBinding
import com.sigmai.stylemento.databinding.FragmentMyPageClosetBinding
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageClosetFragment : BaseFragment<FragmentMyPageClosetBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_closet
    private val viewModel: MyPageViewModel by viewModels()

    val testDataSet = arrayOf("1", "2", "3")

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_my_page_closet, container, false)

        val closetRecyclerView : RecyclerView = v.findViewById(R.id.user_closet_recycler)
        val closetAdapter = UserClosetAdapter(testDataSet)
        val gridLayoutManager = GridLayoutManager(context,3)

        closetRecyclerView.adapter = closetAdapter
        gridLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        closetRecyclerView.layoutManager = gridLayoutManager
        return v
    }
}