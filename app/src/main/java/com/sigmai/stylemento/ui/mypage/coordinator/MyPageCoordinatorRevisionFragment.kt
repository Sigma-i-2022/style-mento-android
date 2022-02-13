package com.sigmai.stylemento.ui.mypage.coordinator

import android.app.Activity
import android.content.Intent
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
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.databinding.FragmentMyPageCoordinatorRevisionBinding
import com.sigmai.stylemento.global.base.HavingImage
import com.sigmai.stylemento.ui.mypage.coordinator.dialog.CoordinatorImageSelectionDialog
import com.sigmai.stylemento.ui.mypage.TagAdapter
import com.sigmai.stylemento.ui.mypage.TagSelectionDialog
import com.sigmai.stylemento.ui.mypage.coordinator.viewModel.MyPageCoordinatorRevisionViewModel
import com.sigmai.stylemento.global.base.HavingTag
import com.sigmai.stylemento.global.constant.TagType
import com.sigmai.stylemento.ui.mypage.ImageSelectionDialog

class MyPageCoordinatorRevisionFragment : BaseFragment<FragmentMyPageCoordinatorRevisionBinding>(), HavingTag, HavingImage {
    override val layoutResourceId = R.layout.fragment_my_page_coordinator_revision
    private val viewModel: MyPageCoordinatorRevisionViewModel by viewModels()

    override lateinit var getResultFromCamera : ActivityResultLauncher<Intent>
    override lateinit var getResultFromGallery : ActivityResultLauncher<Intent>
    private var uri : Uri? = Client.getCoordinatorInfo().profile

    private var tags : MutableList<TagType> = mutableListOf()
    private val tagAdapter = TagAdapter()

    private var introductionText : String = ""

    override fun initState() {
        super.initState()
        viewModel.getCoordinatorInfo()
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this, {
            findNavController().navigateUp()
        })
        viewModel.startSave.observe(this, {
            Client.getCoordinatorInfo().introduction = introductionText
            Client.getCoordinatorInfo().styleTags = tags
            Client.getCoordinatorInfo().profile = uri
            findNavController().navigateUp()
        })
        viewModel.startTagAddition.observe(this, {
            val dialog = TagSelectionDialog(this)
            dialog.show(childFragmentManager, "TagSelectionDialog")
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.myPageCoordinatorRevisionProfileImg.setOnClickListener(View.OnClickListener {
            val dialog = ImageSelectionDialog(this)
            dialog.show(childFragmentManager, "ImageSelectionDialog")
        })

        binding.myPageCoordinatorRevisionIntroductionEditText.setText(Client.getCoordinatorInfo().introduction)
        binding.myPageCoordinatorRevisionIntroductionEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                introductionText = p0.toString()
            }
        })

        tagAdapter.setDataSet(Client.getCoordinatorInfo().styleTags)
        binding.myPageCoordinatorRevisionStyleTagRecyclerView.adapter = tagAdapter

        Glide.with(this).load(uri).into(binding.myPageCoordinatorRevisionProfileImg)
        getResultFromGallery = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == Activity.RESULT_OK){
                val intent = it.data
                uri = intent?.data
                Glide.with(this).load(uri).into(binding.myPageCoordinatorRevisionProfileImg)
            }
        }
    }
    override fun setTags(tagTypes: MutableList<TagType>){
        tags = tagTypes
        tagAdapter.setDataSet(tags)
        binding.myPageCoordinatorRevisionStyleTagRecyclerView.adapter = tagAdapter
    }
}