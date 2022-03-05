package com.sigmai.stylemento.ui.coordinator_application

import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentSnsBinding
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.global.base.BaseFragment

class SnsFragment : BaseFragment<FragmentSnsBinding>() {
    override val layoutResourceId = R.layout.fragment_sns
    private val viewModel: ApplicationViewPagerViewModel = AppConfigs.applicationViewPagerViewModel

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun initState() {
        binding.snsList.adapter = SnsAdapter()
    }
}