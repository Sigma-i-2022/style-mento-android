package com.sigmai.stylemento.ui.mypage.coordinator

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.databinding.FragmentMyPageWorkScrollBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.mypage.coordinator.adapter.CoordinatorWorkItemAdapter
import com.sigmai.stylemento.ui.mypage.coordinator.viewModel.MyPageWorkScrollViewModel

class MyPageWorkScrollFragment : BaseFragment<FragmentMyPageWorkScrollBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_work_scroll
    private val viewModel: MyPageWorkScrollViewModel by viewModels()

    override fun initState() {
        super.initState()
        viewModel.position.value = arguments?.getInt("position")!!
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this, {
            findNavController().navigateUp()
        })

        binding.myPageCoordinatorWorkScrollRecycler.adapter =
            CoordinatorWorkItemAdapter(Client.getCoordinatorInfo().workItems, viewModel)
        viewModel.position.observe(this, {
            binding.myPageCoordinatorWorkScrollRecycler.scrollToPosition(viewModel.position.value!!)
        })
    }
}