package com.sigmai.stylemento.feature.signup

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<EditText>(R.id.signup_edit_text).addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.inputText[viewModel.currentPageIndex.value!!].postValue(text.toString())

                val button = view.findViewById<Button>(R.id.button_in_email)
                val validator = ValidationUtil()

                if(viewModel.currentPageIndex.value == 1) {
                    if(text?.length == 4) {
                        button.setOnClickListener {
                            findNavController().navigate(R.id.action_signup_email_to_signup_password)
                        }
                        viewModel.isClickable[viewModel.currentPageIndex.value!!].postValue(true)
                    }
                    else {
                        button.setOnClickListener {}
                        viewModel.isClickable[viewModel.currentPageIndex.value!!].postValue(false)
                    }
                }

                if(viewModel.currentPageIndex.value == 1) return

                if(validator.validateEmail(text.toString())) {
                    button.setOnClickListener {
                        viewModel.nextPage()
                    }
                    viewModel.isClickable[viewModel.currentPageIndex.value!!].postValue(true)
                }
                else {
                    button.setOnClickListener {}
                    viewModel.isClickable[viewModel.currentPageIndex.value!!].postValue(false)
                }
            }
            override fun afterTextChanged(text: Editable?) {}
        })
    }
}