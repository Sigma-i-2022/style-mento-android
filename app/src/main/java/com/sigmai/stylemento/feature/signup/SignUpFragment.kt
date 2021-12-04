package com.sigmai.stylemento.feature.signup

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentSignUpBinding
import com.sigmai.stylemento.global.base.BaseFragment

class SignUpFragment : BaseFragment<FragmentSignUpBinding>() {
    override val layoutResourceId = R.layout.fragment_sign_up
    private val viewModel: SignUpViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }
}