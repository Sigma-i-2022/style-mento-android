package com.sigmai.stylemento.feature.home.notification

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentNotificationBinding
import com.sigmai.stylemento.global.base.BaseFragment

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    override val layoutResourceId = R.layout.fragment_notification
    private val viewModel: NotificationViewModel by viewModels()

    override fun initDataBinding() {
        binding.viewModel = viewModel
    }
}