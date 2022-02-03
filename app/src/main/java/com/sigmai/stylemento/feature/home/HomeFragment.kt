package com.sigmai.stylemento.feature.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentHomeBinding
import com.sigmai.stylemento.global.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val layoutResourceId = R.layout.fragment_home
    private val viewModel: HomeViewModel by viewModels()

    override fun initState() {
        super.initState()
        getUserInfo()
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startNotification.observe(this, {
            findNavController().navigate(R.id.action_main_to_notification)
        })
    }

    fun getUserInfo() {
        viewModel.getUserInfo()
    }
}