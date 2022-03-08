package com.sigmai.stylemento.ui.mypage.coordinator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.WorkItem
import com.sigmai.stylemento.databinding.FragmentMyPageWorkAddBinding
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.usecase.coordinator.GetCoordinatorUseCase
import com.sigmai.stylemento.domain.usecase.GetWorkItemUseCase
import com.sigmai.stylemento.ui.mypage.TagSelectionDialog
import com.sigmai.stylemento.ui.mypage.coordinator.viewModel.MyPageWorkAddViewModel
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.base.HavingImage
import com.sigmai.stylemento.global.base.HavingTag2
import com.sigmai.stylemento.ui.mypage.ImageSelectionDialog
import com.sigmai.stylemento.ui.mypage.adapter.SampleTagAdapter
import java.text.SimpleDateFormat

class MyPageWorkAddFragment : BaseFragment<FragmentMyPageWorkAddBinding>(), HavingTag2, HavingImage {
    override val layoutResourceId = R.layout.fragment_my_page_work_add
    private val viewModel: MyPageWorkAddViewModel by viewModels()
    override lateinit var getResultFromCamera: ActivityResultLauncher<Intent>
    override lateinit var getResultFromGallery: ActivityResultLauncher<Intent>

    private lateinit var workItem : WorkItem
    private val getWorkItemUseCase = GetWorkItemUseCase()

    private var position = -1
    override fun initState() {
        super.initState()
        position = arguments?.getInt("position")!!
        if(position >= 0){
            workItem = getWorkItemUseCase(position).copy()
            binding.myPageWorkTitleText.text = "아이템 수정"
            binding.myPageWorkAddSaveButton.text = "수정"
            workItem.isModified = true
        }
        else{
            workItem = WorkItem()
        }
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().popBackStack()
        }
        viewModel.startSave.observe(this) {
            setTime()
            if (position >= 0)
                Client.reviseWorkItem(workItem, position)
            else
                Client.addWorkItem(workItem)
            findNavController().popBackStack()
        }
        viewModel.startTagAddition.observe(this) {
            val dialog = TagSelectionDialog(havingTag2 = this)
            dialog.show(childFragmentManager, "TagSelectionDialog")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageWorkAddItemImg.setOnClickListener{
            val dialog = ImageSelectionDialog(this)
            dialog.show(childFragmentManager, "ImageSelectionDialog")
        }

        setEditTextLayout()
        setTextInit()

        Glide.with(this).load(workItem.photoUrl).into(binding.myPageWorkAddItemImg)
        getResultFromGallery = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == Activity.RESULT_OK){
                val intent = it.data
                val uri = intent?.data
                workItem.photoUrl = uri
                Glide.with(this).load(uri).into(binding.myPageWorkAddItemImg)
            }
        }
    }

    private fun setTextInit(){
        binding.myPageWorkAddDetailEditText.setText(workItem.detail)
        binding.myPageWorkAddModelHeightEditText.setText(workItem.height)
        binding.myPageWorkAddModelWeightEditText.setText(workItem.weight)
        binding.myPageWorkAddTopEditText.setText(workItem.top)
        binding.myPageWorkAddPantsEditText.setText(workItem.pants)
        binding.myPageWorkAddShoesEditText.setText(workItem.shoes)
        binding.myPageWorkAddOtherEditText.setText(workItem.other)
    }

    private fun setEditTextLayout(){
        binding.myPageWorkAddDetailEditText.addTextChangedListener(AdditionPageTextWatcher(workItem, "detail"))
        binding.myPageWorkAddModelHeightEditText.addTextChangedListener(AdditionPageTextWatcher(workItem, "height"))
        binding.myPageWorkAddModelWeightEditText.addTextChangedListener(AdditionPageTextWatcher(workItem, "weight"))
        binding.myPageWorkAddTopEditText.addTextChangedListener(AdditionPageTextWatcher(workItem, "top"))
        binding.myPageWorkAddPantsEditText.addTextChangedListener(AdditionPageTextWatcher(workItem, "pants"))
        binding.myPageWorkAddShoesEditText.addTextChangedListener(AdditionPageTextWatcher(workItem, "shoes"))
        binding.myPageWorkAddOtherEditText.addTextChangedListener(AdditionPageTextWatcher(workItem, "other"))
    }

    private fun setTime(){
        val currentTime : Long = System.currentTimeMillis()
        val dataFormat = SimpleDateFormat("yyyy-MM-dd")
        workItem.time = dataFormat.format(currentTime)
    }

    override fun setTagList(tagList: List<String>) {
        val tagAdapter = SampleTagAdapter(tagList, false)
        binding.myPageWorkAddTagRecycler.adapter = tagAdapter
    }
}
