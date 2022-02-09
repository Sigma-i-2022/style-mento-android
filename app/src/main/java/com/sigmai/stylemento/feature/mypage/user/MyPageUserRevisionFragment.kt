package com.sigmai.stylemento.feature.mypage.user

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageUserRevisionBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.feature.mypage.user.dialog.UserClosetImageSelectionDialog
import com.sigmai.stylemento.feature.mypage.user.dialog.UserImageSelectionDialog
import com.sigmai.stylemento.feature.mypage.user.viewModel.MyPageUserRevisionViewModel

class MyPageUserRevisionFragment : BaseFragment<FragmentMyPageUserRevisionBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_user_revision
    private val viewModel: MyPageUserRevisionViewModel by viewModels()
    private lateinit var getResult : ActivityResultLauncher<Intent>

    override fun initState() {
        super.initState()
        viewModel.getUserInfo()
    }
    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this, {
            backToMyPage()
        })
        viewModel.startSave.observe(this, {
            Client.getUserInfo().introduction = introductionText
            backToMyPage()
        })
    }

    private var introductionText : String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageUserRevisionProfileImg.setOnClickListener(View.OnClickListener {
            val dialog = UserImageSelectionDialog(this)
            dialog.show(childFragmentManager, "ImageSelectionDialog")
        })

        binding.myPageUserRevisionIntroductionEditText.setText(Client.getUserInfo().introduction)
        binding.myPageUserRevisionIntroductionEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                introductionText = p0.toString()
            }
        })

       getResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            //if(it.data?.type == "Image/*"){
                val intent = it.data
                val uri = intent?.data
                Glide.with(this).load(uri).into(binding.myPageUserRevisionProfileImg)
            //}
        }

    }
    private fun backToMyPage(){
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment())
        transaction.commit()
    }

    fun getImage(){
        val intent = Intent()
        intent.type = "Image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        getResult.launch(intent)
    }
}