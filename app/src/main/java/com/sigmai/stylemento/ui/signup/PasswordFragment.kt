package com.sigmai.stylemento.ui.signup

import androidx.fragment.app.activityViewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentPasswordBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.ValidationUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PasswordFragment : BaseFragment<FragmentPasswordBinding>() {
    override val layoutResourceId = R.layout.fragment_password
    val viewModel: SignupViewModel by activityViewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        setupObserver()
    }

    private fun setupObserver() {
        viewModel.password.observe(this) {
            viewModel.isButtonClickable.value = ValidationUtil().validatePassword(it)
        }
    }
}