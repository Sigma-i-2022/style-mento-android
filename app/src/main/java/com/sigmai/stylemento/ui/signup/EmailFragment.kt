package com.sigmai.stylemento.ui.signup

import androidx.fragment.app.activityViewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentEmailBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.ValidationUtil
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class EmailFragment : BaseFragment<FragmentEmailBinding>() {
    override val layoutResourceId = R.layout.fragment_email
    val viewModel: SignupViewModel by activityViewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        setupObserver()
    }

    private fun setupObserver() {
        viewModel.email.observe(this) {
            viewModel.isButtonClickable.value = ValidationUtil().validateEmail(it)
        }
    }
}