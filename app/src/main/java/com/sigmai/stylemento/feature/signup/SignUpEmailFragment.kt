package com.sigmai.stylemento.feature.signup

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
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

                if(viewModel.currentPageIndex.value != 0) return
                ValidationUtil().apply {
                    if(validateEmail(text.toString())) {
                        // TODO : 유효성 검사 통과했을 때 로직
                    }
                    else {
                        // TODO : 유효성 검사 실패했을 때 로직
                    }
                }
            }
            override fun afterTextChanged(text: Editable?) {}
        })
    }
}