package com.sigmai.stylemento.feature.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentSignUpFinishBinding
import com.sigmai.stylemento.global.base.BaseFragment

class SignUpFinishFragment : BaseFragment<FragmentSignUpFinishBinding>() {
    override val layoutResourceId = R.layout.fragment_sign_up_finish

    override fun initState() {
        binding.moveLoginButton.setOnClickListener {
            findNavController().navigate(R.id.action_signup_finish_to_login)
        }
    }
}