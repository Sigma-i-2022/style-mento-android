package com.sigmai.stylemento.ui.setting

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentAccountRegisterBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.TimeUtil
import com.sigmai.stylemento.ui.reservation.adapter.TimeSelectorAdapter
import com.sigmai.stylemento.ui.reservation.viewModel.ReservationViewModel
import com.sigmai.stylemento.databinding.FragmentSettingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountRegisterFragment : BaseFragment<FragmentAccountRegisterBinding>() {
    override val layoutResourceId = R.layout.fragment_account_register
    private val viewModel: AccountRegisterViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigateUp()
        }
        viewModel.startNext.observe(this) {
            viewModel.saveInfo()
            findNavController().navigateUp()
        }
        viewModel.startSetBank.observe(this) {
            val bankBottomSheet = BankBottomSheet(viewModel.bank)
            bankBottomSheet.show(childFragmentManager, bankBottomSheet.tag)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}