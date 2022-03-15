package com.sigmai.stylemento.ui.coordinator_application

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentApplicationViewPagerBinding
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.global.base.BaseFragment

class ApplicationViewPagerFragment : BaseFragment<FragmentApplicationViewPagerBinding>() {
    override val layoutResourceId = R.layout.fragment_application_view_pager
    private val viewModel: ApplicationViewPagerViewModel by activityViewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
        binding.applicationViewpager.adapter = ApplicationViewPagerAdapter(this)
        viewModel.moveNextPageEvent.observe(this) {
            binding.applicationViewpager.currentItem = 1
        }
        viewModel.movePreviousEvent.observe(this) {
            binding.applicationViewpager.currentItem = 0
        }
    }

    override fun initState() {
        viewModel.finishEvent.observe(this) {
            val navController = findNavController()
            navController.navigateUp()
        }
    }
}