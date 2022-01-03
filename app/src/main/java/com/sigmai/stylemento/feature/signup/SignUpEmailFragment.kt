package com.sigmai.stylemento.feature.signup

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
                        setButtonType(button, 2)
                    }
                    else {
                        button.setOnClickListener {}
                        setButtonType(button, 1)
                    }
                }

                if(viewModel.currentPageIndex.value == 1) return

                if(validator.validateEmail(text.toString())) {
                    button.setOnClickListener {
                        viewModel.nextPage()
                    }
                    setButtonType(button, 2)
                }
                else {
                    button.setOnClickListener {}
                    setButtonType(button, 1)
                }
            }
            override fun afterTextChanged(text: Editable?) {}
        })
    }

    fun setButtonType(button: Button, type: Int) {
        if(type == 1) {
            button.setTextColor(ContextCompat.getColor(button.context, R.color.primary))
            button.background = ContextCompat.getDrawable(button.context, R.drawable.button_background_type_1)
        }
        else {
            button.setTextColor(ContextCompat.getColor(button.context, R.color.white))
            button.background = ContextCompat.getDrawable(button.context, R.drawable.button_background_type_2)
        }
    }
}