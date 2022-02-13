package com.sigmai.stylemento.ui.mypage.coordinator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.WorkItem
import com.sigmai.stylemento.databinding.FragmentMyPageWorkAddBinding
import com.sigmai.stylemento.domain.usecase.GetLookbookItemUseCase
import com.sigmai.stylemento.domain.usecase.GetWorkItemUseCase
import com.sigmai.stylemento.ui.mypage.TagAdapter
import com.sigmai.stylemento.ui.mypage.TagSelectionDialog
import com.sigmai.stylemento.ui.mypage.coordinator.dialog.CoordinatorWorkImageSelectionDialog
import com.sigmai.stylemento.ui.mypage.coordinator.viewModel.MyPageWorkAddViewModel
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.base.HavingTag
import com.sigmai.stylemento.global.base.HavingTag2
import com.sigmai.stylemento.global.constant.TagType
import com.sigmai.stylemento.ui.mypage.adapter.SampleTagAdapter
import com.sigmai.stylemento.ui.mypage.user.AdditionPageTextWatcher

class MyPageWorkAddFragment : BaseFragment<FragmentMyPageWorkAddBinding>(), HavingTag2 {
    override val layoutResourceId = R.layout.fragment_my_page_work_add
    private val viewModel: MyPageWorkAddViewModel by viewModels()
    private val tagAdapter = TagAdapter()

    private lateinit var workItem : WorkItem
    private val getWorkItemUseCase = GetWorkItemUseCase()

    override fun initState() {
        super.initState()
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this, {
            backToMyPage()
        })
        viewModel.startSave.observe(this, {
            Client.addWorkItem(workItem)
            backToMyPage()
        })
        viewModel.startTagAddition.observe(this, {
            val dialog = TagSelectionDialog(havingTag2 = this)
            dialog.show(childFragmentManager, "TagSelectionDialog")
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageWorkAddItemImg.setOnClickListener{
            val dialog = CoordinatorWorkImageSelectionDialog()
            dialog.show(childFragmentManager, "ImageSelectionDialog")
        }

        setEditTextLayout()
    }

    private fun setEditTextLayout(){
        binding.myPageWorkAddDetailEditText.addTextChangedListener(AdditionPageTextWatcher(workItem, "detail"))
        binding.myPageWorkAddTopEditText.addTextChangedListener(AdditionPageTextWatcher(workItem, "top"))
        binding.myPageWorkAddPantsEditText.addTextChangedListener(AdditionPageTextWatcher(workItem, "pants"))
        binding.myPageWorkAddShoesEditText.addTextChangedListener(AdditionPageTextWatcher(workItem, "shoes"))
    }

    private fun backToMyPage(){
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageCoordinatorFragment(0))
        transaction.commit()
    }

    override fun setTagList(tagList: List<String>) {
        val tagAdapter = SampleTagAdapter(tagList, false)
        binding.myPageWorkAddTagRecycler.adapter = tagAdapter
    }
}
