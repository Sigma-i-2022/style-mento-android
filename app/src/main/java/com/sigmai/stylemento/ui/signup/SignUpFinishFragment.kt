package com.sigmai.stylemento.ui.signup

import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentSignUpFinishBinding
import com.sigmai.stylemento.global.base.BaseFragment

class SignUpFinishFragment : BaseFragment<FragmentSignUpFinishBinding>() {
    override val layoutResourceId = R.layout.fragment_sign_up_finish

    override fun initState() {
        binding.moveLoginButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}