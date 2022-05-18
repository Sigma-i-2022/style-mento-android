package com.sigmai.stylemento.ui.coordinator_application

import androidx.fragment.app.activityViewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentFormBinding
import com.sigmai.stylemento.global.base.BaseFragment

class FormFragment : BaseFragment<FragmentFormBinding>() {
    override val layoutResourceId = R.layout.fragment_form
    private val viewModel: ApplicationViewPagerViewModel by activityViewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
        viewModel.introduction.observe(this) {
            viewModel.textLength.value = it.length
        }
    }
}