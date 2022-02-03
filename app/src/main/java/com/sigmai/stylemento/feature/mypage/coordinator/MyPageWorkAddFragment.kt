package com.sigmai.stylemento.feature.mypage.coordinator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.WorkItem
import com.sigmai.stylemento.databinding.FragmentMyPageWorkAddBinding
import com.sigmai.stylemento.feature.mypage.TagAdapter
import com.sigmai.stylemento.feature.mypage.TagSelectionDialog
import com.sigmai.stylemento.feature.mypage.coordinator.dialog.CoordinatorWorkImageSelectionDialog
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.base.HavingTag
import com.sigmai.stylemento.global.constant.TagType

class MyPageWorkAddFragment : BaseFragment<FragmentMyPageWorkAddBinding>(), HavingTag {
    override val layoutResourceId = R.layout.fragment_my_page_work_add

    private val tagAdapter = TagAdapter()
    private var workItem : WorkItem = WorkItem(Client.getUserInfo().nickname)
    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {}
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            workItem.deltail = p0.toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageWorkAddBackImg.setOnClickListener(View.OnClickListener {
            backToMyPage()
        })

        binding.myPageWorkAddItemImg.setOnClickListener(View.OnClickListener {
            val dialog = CoordinatorWorkImageSelectionDialog()
            dialog.show(childFragmentManager, "ImageSelectionDialog")
        })

        setEditTextLayout()

        binding.myPageWorkAddSaveButton.setOnClickListener(View.OnClickListener {
            Client.addWorkItem(workItem)
            backToMyPage()
        })

       binding.myPageWorkAddTagAddImg.setOnClickListener(View.OnClickListener {
            val dialog = TagSelectionDialog(this)
            dialog.show(childFragmentManager, "TagSelectionDialog")
        })
    }

    private fun setEditTextLayout(){
        binding.myPageWorkAddDetailEditText.addTextChangedListener(textWatcher)
        binding.myPageWorkAddTopEditText.addTextChangedListener(textWatcher)
        binding.myPageWorkAddPantsEditText.addTextChangedListener(textWatcher)
        binding.myPageWorkAddShoesEditText.addTextChangedListener(textWatcher)
    }

    private fun backToMyPage(){
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageCoordinatorFragment(Client.getCoordinatorInfo(), 0))
        transaction.commit()
    }

    override fun setTags(tagTypes: MutableList<TagType>){
        workItem.tags = tagTypes
        tagAdapter.setDataSet(workItem.tags)
        binding.myPageWorkAddTagRecycler.adapter = tagAdapter
    }
}
