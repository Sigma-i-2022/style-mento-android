package com.sigmai.stylemento.ui.coordinator_application

import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentApplicationViewPagerBinding
import com.sigmai.stylemento.global.base.BaseFragment

class ApplicationViewPagerFragment : BaseFragment<FragmentApplicationViewPagerBinding>() {
    override val layoutResourceId = R.layout.fragment_application_view_pager

    override fun initDataBinding() {
        super.initDataBinding()
        binding.applicationViewpager.adapter = ApplicationViewPagerAdapter(this)
    }
}