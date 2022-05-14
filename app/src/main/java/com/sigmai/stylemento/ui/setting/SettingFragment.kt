package com.sigmai.stylemento.ui.setting

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.TimeUtil
import com.sigmai.stylemento.ui.reservation.adapter.TimeSelectorAdapter
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationViewModel
import com.sigmai.stylemento.databinding.FragmentSettingBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SettingFragment : BaseFragment<FragmentSettingBinding>() {
    override val layoutResourceId = R.layout.fragment_setting
    private val viewModel: SettingViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigateUp()
        }
        viewModel.startInquireByKakao.observe(this) {

        }
        viewModel.startReview.observe(this) {
            Intent(Intent.ACTION_VIEW).run {
                this.data = Uri.parse("market://details?id=com.sigmai.stylemento")
                startActivity(this)
            }
        }
        viewModel.startRegister.observe(this) {
            findNavController().navigate(R.id.action_setting_page_to_account_register_page)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}