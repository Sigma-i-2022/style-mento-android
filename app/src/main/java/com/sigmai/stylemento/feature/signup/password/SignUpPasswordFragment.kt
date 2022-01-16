package com.sigmai.stylemento.feature.signup.password

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentSignUpPasswordBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.ValidationUtil

class SignUpPasswordFragment : BaseFragment<FragmentSignUpPasswordBinding>() {
    override val layoutResourceId = R.layout.fragment_sign_up_password
    private val viewModel: SignUpPasswordViewModel by viewModels()

    override fun initDataBinding() {
        binding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<EditText>(R.id.signup_password_edit_text).addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.inputText[viewModel.currentPageIndex.value!!].postValue(text.toString())

                val button = view.findViewById<Button>(R.id.signup_next_button)

                button.setOnClickListener {
                    viewModel.nextPage(findNavController())
                }

                viewModel.isValidPassword[viewModel.currentPageIndex.value!!].postValue(validate(text.toString()))
            }
            override fun afterTextChanged(text: Editable?) {}
        })
    }

    fun validate(string: String) : Boolean {
        return if(viewModel.currentPageIndex.value == 0) {
            ValidationUtil().validatePassword(string)
        } else {
            string == viewModel.inputText[0].value
        }
    }
}