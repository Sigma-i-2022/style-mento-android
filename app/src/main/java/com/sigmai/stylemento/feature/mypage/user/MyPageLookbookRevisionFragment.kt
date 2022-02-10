package com.sigmai.stylemento.feature.mypage.user

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookRevisionBinding
import com.sigmai.stylemento.feature.mypage.TagAdapter
import com.sigmai.stylemento.feature.mypage.TagSelectionDialog
import com.sigmai.stylemento.feature.mypage.user.dialog.*
import com.sigmai.stylemento.feature.mypage.user.viewModel.MyPageLookbookRevisionViewModel
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.base.HavingTag
import com.sigmai.stylemento.global.constant.TagType

class MyPageLookbookRevisionFragment(private val position : Int)
    : BaseFragment<FragmentMyPageLookbookRevisionBinding>(), HavingTag {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook_revision
    private val viewModel: MyPageLookbookRevisionViewModel by viewModels()

    private val tagAdapter = TagAdapter()

    override fun initState() {
        super.initState()
        viewModel.setItemInfo(Client.getUserInfo().lookbookItems[position])
    }
    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this, {
            backToMyPage()
        })
        viewModel.startSave.observe(this, {
            Client.reviseLookbookItem(viewModel.item.value!!, position)
            backToMyPage()
        })
        viewModel.startTagAdd.observe(this, {
            val dialog = TagSelectionDialog(this)
            dialog.show(childFragmentManager, "TagSelectionDialog")
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tagAdapter.setDataSet(viewModel.item.value?.tags)
        binding.myPageLookbookRevisionTagRecycler.adapter = tagAdapter

        setEditTextLayout()

        binding.myPageLookbookRevisionItemImg.setOnClickListener(View.OnClickListener {
            val dialog = UserLookbookImageSelectionDialog()
            dialog.show(childFragmentManager, "ImageSelectionDialog")
        })
    }

    private fun setEditTextLayout(){
        binding.myPageLookbookRevisionDetailEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.item.value!!.detail = p0.toString()
            }
        })
        binding.myPageLookbookRevisionTopEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.item.value!!.top = p0.toString()
            }
        })
        binding.myPageLookbookRevisionPantsEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.item.value!!.pants = p0.toString()
            }
        })
        binding.myPageLookbookRevisionShoesEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.item.value!!.shoes = p0.toString()
            }
        })
    }

    private fun backToMyPage(){
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment())
        transaction.commit()
    }

    override fun setTags(tagTypes: MutableList<TagType>){
        viewModel.item.value!!.tags = tagTypes
        tagAdapter.setDataSet(tagTypes)
        binding.myPageLookbookRevisionTagRecycler.adapter = tagAdapter
    }
}