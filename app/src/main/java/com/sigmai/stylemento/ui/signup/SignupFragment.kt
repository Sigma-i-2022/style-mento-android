package com.sigmai.stylemento.ui.signup

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentSignupBinding
import com.sigmai.stylemento.global.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignupFragment : BaseFragment<FragmentSignupBinding>() {
    override val layoutResourceId = R.layout.fragment_signup
    val viewModel: SignUpViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        setupAdapter()
        setupObserver()
    }

    private fun setupAdapter() {
        binding.viewpager.adapter = SignupFragmentStateAdapter(this)
    }

    private fun setupObserver() {
        viewModel.previousEvent.observe(this) {

        }

        viewModel.nextEvent.observe(this) {

        }
    }
}