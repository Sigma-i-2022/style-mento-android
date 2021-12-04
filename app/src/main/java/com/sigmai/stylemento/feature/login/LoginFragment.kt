package com.sigmai.stylemento.feature.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
            findNavController().navigate(LoginFragmentDirections.actionLoginToSignup())
        })
    }
}