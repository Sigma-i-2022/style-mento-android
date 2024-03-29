package com.sigmai.stylemento.ui.signup

import androidx.fragment.app.activityViewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentPasswordConfirmBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.ValidationUtil
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PasswordConfirmFragment : BaseFragment<FragmentPasswordConfirmBinding>() {
    override val layoutResourceId = R.layout.fragment_password_confirm
    val viewModel: SignupViewModel by activityViewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        setupObserver()
    }

    private fun setupObserver() {
        viewModel.passwordConfirm.observe(this) {
            viewModel.isButtonClickable.value = it == viewModel.password.value!!
        }
    }
}