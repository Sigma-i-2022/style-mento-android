package com.sigmai.stylemento.feature.signup

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentSignUpBinding
import com.sigmai.stylemento.global.base.BaseFragment

class SignUpFragment : BaseFragment<FragmentSignUpBinding>() {
    override val layoutResourceId = R.layout.fragment_sign_up
    private val viewModel: SignUpViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<EditText>(R.id.signup_edit_text).addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.inputText[viewModel.currentPageIndex.value!!].postValue(text.toString())
                if(text?.length == 20) {
                    Toast.makeText(context, "너무 길어요!!", Toast.LENGTH_SHORT)
                }
            }
            override fun afterTextChanged(text: Editable?) {}
        })
    }
}