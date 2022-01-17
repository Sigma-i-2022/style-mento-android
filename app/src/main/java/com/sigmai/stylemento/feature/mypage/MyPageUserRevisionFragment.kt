package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageUserRevisionBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.data.model.Client

class MyPageUserRevisionFragment : BaseFragment<FragmentMyPageUserRevisionBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_user_revision

    val testDataSet = arrayOf("type1", "type2", "type3")

    var introductionText : String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.myPageUserRevisionBackImg.setOnClickListener(View.OnClickListener {
            backToMyPage()
        })

        binding.myPageUserRevisionIntroductionEditText.setText(Client.getUserIntroduction())
        binding.myPageUserRevisionIntroductionEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                introductionText = p0.toString()
            }
        })

        binding.myPageUserRevisionSaveButton.setOnClickListener(View.OnClickListener {
            Client.setUserIntroduction(introductionText)
            backToMyPage()
        })
    }

    private fun backToMyPage(){
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment())
        transaction.commit()
    }
}