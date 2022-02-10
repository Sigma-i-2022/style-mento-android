package com.sigmai.stylemento.ui.signup.email

import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentSignUpEmailBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.ValidationUtil

class SignUpEmailFragment : BaseFragment<FragmentSignUpEmailBinding>() {
    override val layoutResourceId = R.layout.fragment_sign_up_email
    private val viewModel: SignUpEmailViewModel by viewModels()

    override fun initDataBinding() {
        binding.viewModel = viewModel
    }

    override fun initState() {
        binding.signupEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.inputText[viewModel.currentPageIndex.value!!].postValue(text.toString())

                binding.buttonInEmail.setOnClickListener {
                    viewModel.nextPage(findNavController())
                }

                viewModel.isClickable[viewModel.currentPageIndex.value!!].postValue(validate(text.toString()))
            }

            override fun afterTextChanged(text: Editable?) {}
        })
    }

    fun validate(string: String): Boolean {
        return if (viewModel.currentPageIndex.value == 0) {
            ValidationUtil().validateEmail(string)
        } else {
            string.length == 4
        }
    }
}