package com.sigmai.stylemento.ui.coordinator_application

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentCoordinatorApplicationBinding
import com.sigmai.stylemento.global.base.BaseFragment

class CoordinatorApplicationFragment : BaseFragment<FragmentCoordinatorApplicationBinding>() {
    override val layoutResourceId = R.layout.fragment_coordinator_application
    val viewModel: CoordinatorApplicationViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        setupObserver()
    }

    private fun setupObserver() {
        viewModel.finishEvent.observe(this) {
            val navController = findNavController()
            navController.navigateUp()
        }
    }
}