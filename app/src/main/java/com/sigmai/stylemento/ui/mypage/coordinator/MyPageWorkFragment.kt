package com.sigmai.stylemento.ui.mypage.coordinator

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageWorkBinding
import com.sigmai.stylemento.ui.mypage.coordinator.adapter.CoordinatorWorkAdapter
import com.sigmai.stylemento.ui.mypage.coordinator.viewModel.MyPageWorkViewModel
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageWorkFragment() : BaseFragment<FragmentMyPageWorkBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_work
    private val viewModel: MyPageWorkViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startAddition.observe(this, {
            val bundle = bundleOf("position" to -1)
            findNavController().navigate(R.id.action_main_to_lookbook_add, bundle)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val workAdapter = CoordinatorWorkAdapter()
        val gridLayoutManager = GridLayoutManager(context,3, GridLayoutManager.VERTICAL, false)

        binding.myPageWorkRecycler.adapter = workAdapter
        binding.myPageWorkRecycler.layoutManager = gridLayoutManager
    }
}