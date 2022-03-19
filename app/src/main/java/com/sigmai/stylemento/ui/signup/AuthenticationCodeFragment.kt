package com.sigmai.stylemento.ui.signup

import androidx.fragment.app.activityViewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentAuthenticationCodeBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.ValidationUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthenticationCodeFragment : BaseFragment<FragmentAuthenticationCodeBinding>() {
    override val layoutResourceId = R.layout.fragment_authentication_code
    val viewModel: SignupViewModel by activityViewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        setupObserver()
    }

    fun setupObserver() {
        viewModel.authenticationCode.observe(this) {
            viewModel.isButtonClickable.value = ValidationUtil().validateCode(it)
        }
    }
}