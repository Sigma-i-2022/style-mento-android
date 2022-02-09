package com.sigmai.stylemento.feature.mypage.user

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookAddBinding
import com.sigmai.stylemento.feature.mypage.TagAdapter
import com.sigmai.stylemento.feature.mypage.TagSelectionDialog
import com.sigmai.stylemento.feature.mypage.adapter.SampleTagAdapter
import com.sigmai.stylemento.feature.mypage.user.dialog.*
import com.sigmai.stylemento.feature.mypage.user.viewModel.MyPageLookbookAddViewModel
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.base.HavingTag
import com.sigmai.stylemento.global.base.HavingTag2
import com.sigmai.stylemento.global.constant.TagType

class MyPageLookbookAddFragment : BaseFragment<FragmentMyPageLookbookAddBinding>(), HavingTag2 {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook_add
    private val viewModel: MyPageLookbookAddViewModel by viewModels()

    private var lookbookItem : LookbookItem = LookbookItem(Client.getUserInfo().nickname)

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
            Client.addLookbookItem(lookbookItem)
            backToMyPage()
        })
        viewModel.startTagAdd.observe(this, {
            val dialog = TagSelectionDialog(havingTag2 = this)
            dialog.show(childFragmentManager, "TagSelectionDialog")
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageLookbookAddItemImg.setOnClickListener(View.OnClickListener {
            val dialog = UserLookbookImageSelectionDialog()
            dialog.show(childFragmentManager, "ImageSelectionDialog")
        })

        setEditTextLayout()
    }

    private fun setEditTextLayout(){
        binding.myPageLookbookAddDetailEditText.addTextChangedListener(AdditionPageTextWatcher(lookbookItem, "detail"))
        binding.myPageLookbookAddTopEditText.addTextChangedListener(AdditionPageTextWatcher(lookbookItem, "top"))
        binding.myPageLookbookAddPantsEditText.addTextChangedListener(AdditionPageTextWatcher(lookbookItem, "pants"))
        binding.myPageLookbookAddShoesEditText.addTextChangedListener(AdditionPageTextWatcher(lookbookItem, "shoes"))
    }

    private fun backToMyPage(){
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment())
        transaction.commit()
    }

    override fun setTagList(tagList: List<String>) {
        val tagAdapter = SampleTagAdapter(tagList, false)
        binding.myPageLookbookAddTagRecycler.adapter = tagAdapter
    }
}