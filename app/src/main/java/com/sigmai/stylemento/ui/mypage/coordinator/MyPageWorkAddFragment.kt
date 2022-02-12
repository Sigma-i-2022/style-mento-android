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
import com.sigmai.stylemento.ui.mypage.TagAdapter
import com.sigmai.stylemento.ui.mypage.TagSelectionDialog
import com.sigmai.stylemento.ui.mypage.coordinator.dialog.CoordinatorWorkImageSelectionDialog
import com.sigmai.stylemento.ui.mypage.coordinator.viewModel.MyPageWorkAddViewModel
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.base.HavingTag
import com.sigmai.stylemento.global.constant.TagType

class MyPageWorkAddFragment : BaseFragment<FragmentMyPageWorkAddBinding>(), HavingTag {
    override val layoutResourceId = R.layout.fragment_my_page_work_add
    private val viewModel: MyPageWorkAddViewModel by viewModels()
    private val tagAdapter = TagAdapter()
    private var workItem : WorkItem = WorkItem(Client.getUserInfo().nickname)

    override fun initState() {
        super.initState()
        viewModel.getCoordinatorInfo()
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
            val dialog = TagSelectionDialog(this)
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
        binding.myPageWorkAddDetailEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                workItem.deltail = p0.toString()
            }
        })
        binding.myPageWorkAddTopEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                workItem.top = p0.toString()
            }
        })
        binding.myPageWorkAddPantsEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                workItem.pants = p0.toString()
            }
        })
        binding.myPageWorkAddShoesEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                workItem.shoes = p0.toString()
            }
        })
    }

    private fun backToMyPage(){
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageCoordinatorFragment(0))
        transaction.commit()
    }

    override fun setTags(tagTypes: MutableList<TagType>){
        workItem.tags = tagTypes
        tagAdapter.setDataSet(workItem.tags)
        binding.myPageWorkAddTagRecycler.adapter = tagAdapter
    }
}