package com.sigmai.stylemento.ui.mypage.coordinator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageWorkScrollBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.mypage.coordinator.adapter.CoordinatorWorkItemAdapter
import com.sigmai.stylemento.ui.mypage.coordinator.viewModel.MyPageWorkScrollViewModel

class MyPageWorkScrollFragment : BaseFragment<FragmentMyPageWorkScrollBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_work_scroll
    private val viewModel: MyPageWorkScrollViewModel by viewModels()

    private var position = 0
    private lateinit var workItemAdapter : CoordinatorWorkItemAdapter
    override fun initState() {
        super.initState()
        position = arguments?.getInt("position")!!
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this, {
            findNavController().navigateUp()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        workItemAdapter = CoordinatorWorkItemAdapter(this)
        binding.myPageCoordinatorWorkScrollRecycler.adapter = workItemAdapter
        binding.myPageCoordinatorWorkScrollRecycler.scrollToPosition(position)
    }

    fun updateAdapter(position : Int){
        workItemAdapter = CoordinatorWorkItemAdapter(this)
        binding.myPageCoordinatorWorkScrollRecycler.adapter = workItemAdapter
        if(workItemAdapter.itemCount == position)
            binding.myPageCoordinatorWorkScrollRecycler.scrollToPosition(position - 1)
        else
            binding.myPageCoordinatorWorkScrollRecycler.scrollToPosition(position)
    }
}