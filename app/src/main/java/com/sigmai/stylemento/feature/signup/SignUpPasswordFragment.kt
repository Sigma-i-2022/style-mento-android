package com.sigmai.stylemento.feature.signup

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentSignUpPasswordBinding
import com.sigmai.stylemento.global.base.BaseFragment

class SignUpPasswordFragment : BaseFragment<FragmentSignUpPasswordBinding>() {
    override val layoutResourceId = R.layout.fragment_sign_up_password
    private val viewModel: SignUpPasswordViewModel by viewModels()

    override fun initDataBinding() {
        binding.viewModel = viewModel
    }
}