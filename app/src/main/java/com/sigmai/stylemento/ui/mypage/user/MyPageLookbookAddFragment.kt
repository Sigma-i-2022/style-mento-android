package com.sigmai.stylemento.ui.mypage.user

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.hardware.input.InputManager
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookAddBinding
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.usecase.GetLookbookItemUseCase
import com.sigmai.stylemento.domain.usecase.GetUserUseCase
import com.sigmai.stylemento.ui.mypage.TagSelectionDialog
import com.sigmai.stylemento.ui.mypage.adapter.SampleTagAdapter
import com.sigmai.stylemento.ui.mypage.user.dialog.*
import com.sigmai.stylemento.ui.mypage.user.viewModel.MyPageLookbookAddViewModel
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.base.HavingImage
import com.sigmai.stylemento.global.base.HavingTag2
import com.sigmai.stylemento.ui.mypage.ImageSelectionDialog
import java.text.SimpleDateFormat

class MyPageLookbookAddFragment() : BaseFragment<FragmentMyPageLookbookAddBinding>(), HavingTag2, HavingImage {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook_add
    private val viewModel: MyPageLookbookAddViewModel by viewModels()
    override lateinit var getResultFromCamera: ActivityResultLauncher<Intent>
    override lateinit var getResultFromGallery: ActivityResultLauncher<Intent>

    private lateinit var lookbookItem : LookbookItem
    private val getLookbookItemUseCase = GetLookbookItemUseCase()
    private val inputManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?

    private var position = -1
    override fun initState() {
        super.initState()
        position = arguments?.getInt("position")!!
        if(position >= 0){
            lookbookItem = getLookbookItemUseCase(position).copy()
            binding.myPageLookbookTitleText.text = "아이템 수정"
            binding.myPageLookbookAddSaveButton.text = "수정"
        }
        else{
            val getUserUseCase = GetUserUseCase(AppConfigs.userRepository)
            lookbookItem = LookbookItem(getUserUseCase().nickname)
        }
    }
    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this, {
            //inputManager?.hideSoftInputFromWindow(binding.myPageLookbookAddDetailEditText.windowToken, 0)
            findNavController().popBackStack()
        })
        viewModel.startSave.observe(this, {
            setTime()
            if(position >= 0)
                Client.reviseLookbookItem(lookbookItem, position)
            else
                Client.addLookbookItem(lookbookItem)
            //inputManager?.hideSoftInputFromWindow(binding.myPageLookbookAddDetailEditText.windowToken, 0)
            findNavController().popBackStack()
        })
        viewModel.startTagAdd.observe(this, {
            val dialog = TagSelectionDialog(havingTag2 = this)
            dialog.show(childFragmentManager, "TagSelectionDialog")
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageLookbookAddItemImg.setOnClickListener(View.OnClickListener {
            val dialog = ImageSelectionDialog(this)
            dialog.show(childFragmentManager, "ImageSelectionDialog")
        })

        setEditTextLayout()
        setTextInit()

        Glide.with(this).load(lookbookItem.photoUrl).into(binding.myPageLookbookAddItemImg)
        getResultFromGallery = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == Activity.RESULT_OK){
                val intent = it.data
                val uri = intent?.data
                lookbookItem.photoUrl = uri
                Glide.with(this).load(uri).into(binding.myPageLookbookAddItemImg)
            }
        }
    }
    private fun setTextInit(){
        binding.myPageLookbookAddDetailEditText.setText(lookbookItem.detail)
        binding.myPageLookbookAddTopEditText.setText(lookbookItem.top)
        binding.myPageLookbookAddPantsEditText.setText(lookbookItem.pants)
        binding.myPageLookbookAddShoesEditText.setText(lookbookItem.shoes)
    }
    private fun setEditTextLayout(){
        binding.myPageLookbookAddDetailEditText.addTextChangedListener(AdditionPageTextWatcher(lookbookItem, "detail"))
        binding.myPageLookbookAddTopEditText.addTextChangedListener(AdditionPageTextWatcher(lookbookItem, "top"))
        binding.myPageLookbookAddPantsEditText.addTextChangedListener(AdditionPageTextWatcher(lookbookItem, "pants"))
        binding.myPageLookbookAddShoesEditText.addTextChangedListener(AdditionPageTextWatcher(lookbookItem, "shoes"))
    }
    private fun setTime(){
        val currentTime : Long = System.currentTimeMillis()
        val dataFormat = SimpleDateFormat("yyyy-MM-dd")
        lookbookItem.time = dataFormat.format(currentTime)
    }

    override fun setTagList(tagList: List<String>) {
        val tagAdapter = SampleTagAdapter(tagList, false)
        binding.myPageLookbookAddTagRecycler.adapter = tagAdapter
    }
}