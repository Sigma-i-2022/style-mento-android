package com.sigmai.stylemento.ui.login

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentLoginBinding
import com.sigmai.stylemento.global.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override val layoutResourceId = R.layout.fragment_login
    private val viewModel: LoginViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startNext.observe(this, Observer {
            findNavController().navigate(R.id.action_login_to_signup)
        })
    }
}