package com.sigmai.stylemento.ui.coordinator_application

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentFormBinding
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.global.base.BaseFragment

class FormFragment : BaseFragment<FragmentFormBinding>() {
    override val layoutResourceId = R.layout.fragment_form
    private val viewModel: ApplicationViewPagerViewModel = AppConfigs.applicationViewPagerViewModel

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }
}