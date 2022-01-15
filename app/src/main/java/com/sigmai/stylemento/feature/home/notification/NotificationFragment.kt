package com.sigmai.stylemento.feature.home.notification

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Notification
import com.sigmai.stylemento.databinding.FragmentNotificationBinding
import com.sigmai.stylemento.feature.home.adapter.NotificationAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    override val layoutResourceId = R.layout.fragment_notification
    private val viewModel: NotificationViewModel by viewModels()

    override fun initDataBinding() {
        binding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val notificationRecyclerView = view.findViewById<RecyclerView>(R.id.notification_recycler_view)
        notificationRecyclerView.adapter = NotificationAdapter()
    }
}