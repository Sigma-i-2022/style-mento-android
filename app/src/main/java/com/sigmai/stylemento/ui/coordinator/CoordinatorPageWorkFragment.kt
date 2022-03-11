package com.sigmai.stylemento.ui.coordinator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentCoordinatorPageWorkBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.coordinator.adapter.CoordinatorPageWorkAdapter

class CoordinatorPageWorkFragment : BaseFragment<FragmentCoordinatorPageWorkBinding>() {
    override val layoutResourceId = R.layout.fragment_coordinator_page_work
    private val viewModel: CoordinatorPageViewModel by activityViewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun initState() {
        setupObserver()
        setupRecyclerViewAdapter()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupObserver() {
        viewModel.coordinator.observe(this) {
            binding.coordinatorPageWorkRecycler.adapter!!.notifyDataSetChanged()
        }
    }

    private fun setupRecyclerViewAdapter() {
        binding.coordinatorPageWorkRecycler.adapter = CoordinatorPageWorkAdapter()
    }
}