package com.sigmai.stylemento.ui.setting

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentAccountRegisterBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.BankUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountRegisterFragment : BaseFragment<FragmentAccountRegisterBinding>() {
    override val layoutResourceId = R.layout.fragment_account_register
    private val viewModel: AccountRegisterViewModel by viewModels()

    var bank = ArrayList<String>()
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
            val bankBottomSheet = BankBottomSheet {
                if (it >= 0) {
                    viewModel.bank.value = BankUtil.getBank(it)
                }
            }
            bankBottomSheet.show(childFragmentManager, "dialog")
        }
    }
}