package com.sigmai.stylemento.ui.mypage.coordinator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageWorkBinding
import com.sigmai.stylemento.ui.mypage.coordinator.adapter.CoordinatorWorkAdapter
import com.sigmai.stylemento.ui.mypage.coordinator.viewModel.MyPageWorkViewModel
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageWorkFragment() : BaseFragment<FragmentMyPageWorkBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_work
    private val viewModel: MyPageWorkViewModel by viewModels()

    override fun initState() {
        super.initState()
        viewModel.getCoordinatorInfo()
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startAddition.observe(this, {
            val transaction = parentFragment?.parentFragmentManager?.beginTransaction()
            transaction?.replace(R.id.my_page_frameLayout, MyPageWorkAddFragment())
            transaction?.commit()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val workAdapter = CoordinatorWorkAdapter(this)
        val gridLayoutManager = GridLayoutManager(context,3, GridLayoutManager.VERTICAL, false)

        binding.myPageWorkRecycler.adapter = workAdapter
        binding.myPageWorkRecycler.layoutManager = gridLayoutManager
    }
}