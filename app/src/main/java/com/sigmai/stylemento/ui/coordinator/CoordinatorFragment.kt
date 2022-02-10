package com.sigmai.stylemento.ui.coordinator

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentCoordinatorBinding
import com.sigmai.stylemento.ui.coordinator.adapter.CoordinatorAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class CoordinatorFragment : BaseFragment<FragmentCoordinatorBinding>() {
    override val layoutResourceId = R.layout.fragment_coordinator
    private val viewModel: CoordinatorViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        setupAdapter()
    }

    fun setupAdapter() {
        binding.coordinatorList.adapter = CoordinatorAdapter()
    }
}