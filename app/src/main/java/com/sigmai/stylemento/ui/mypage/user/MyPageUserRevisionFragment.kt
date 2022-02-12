package com.sigmai.stylemento.ui.mypage.user

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageUserRevisionBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.global.base.HavingImage
import com.sigmai.stylemento.ui.mypage.ImageSelectionDialog
import com.sigmai.stylemento.ui.mypage.user.viewModel.MyPageUserRevisionViewModel

class MyPageUserRevisionFragment : BaseFragment<FragmentMyPageUserRevisionBinding>(), HavingImage {
    override val layoutResourceId = R.layout.fragment_my_page_user_revision
    private val viewModel: MyPageUserRevisionViewModel by viewModels()

    override lateinit var getResultFromCamera : ActivityResultLauncher<Intent>
    override lateinit var getResultFromGallery : ActivityResultLauncher<Intent>
    private var uri : Uri? = Client.getUserInfo().profile
    override fun initState() {
        super.initState()
        viewModel.getUserInfo()
    }
    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this, {
            findNavController().navigateUp()
        })
        viewModel.startSave.observe(this, {
            Client.getUserInfo().introduction = introductionText
            Client.getUserInfo().profile = uri
            findNavController().navigateUp()
        })
    }

    private var introductionText : String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageUserRevisionProfileImg.setOnClickListener(View.OnClickListener {
            val dialog = ImageSelectionDialog(this)
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
        Glide.with(this).load(uri).into(binding.myPageUserRevisionProfileImg)
        getResultFromCamera = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == Activity.RESULT_OK){
                val imageBitmap = it.data?.extras?.get("data") as Bitmap
                binding.myPageUserRevisionProfileImg.setImageBitmap(imageBitmap)
            }
        }

        getResultFromGallery = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == Activity.RESULT_OK){
                val intent = it.data
                uri = intent?.data
                Glide.with(this).load(uri).into(binding.myPageUserRevisionProfileImg)
            }
        }

    }
}