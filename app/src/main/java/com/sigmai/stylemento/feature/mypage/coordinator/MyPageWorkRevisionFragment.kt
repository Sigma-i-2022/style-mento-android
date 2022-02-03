package com.sigmai.stylemento.feature.mypage.coordinator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.WorkItem
import com.sigmai.stylemento.databinding.FragmentMyPageWorkRevisionBinding
import com.sigmai.stylemento.feature.mypage.TagAdapter
import com.sigmai.stylemento.feature.mypage.TagSelectionDialog
import com.sigmai.stylemento.feature.mypage.coordinator.dialog.CoordinatorWorkImageSelectionDialog
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.base.HavingTag
import com.sigmai.stylemento.global.constant.TagType

class MyPageWorkRevisionFragment(private var workItem : WorkItem, private val position : Int)
    : BaseFragment<FragmentMyPageWorkRevisionBinding>(), HavingTag {
    override val layoutResourceId = R.layout.fragment_my_page_work_revision

    private val tagAdapter = TagAdapter()
    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {}
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            workItem.deltail = p0.toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTextInit()
        tagAdapter.setDataSet(workItem.tags)
        binding.myPageWorkRevisionTagRecycler.adapter = tagAdapter

        setEditTextLayout()
        binding.myPageWorkRevisionBackImg.setOnClickListener(View.OnClickListener {
            backToMyPage()
        })

        binding.myPageWorkRevisionItemImg.setOnClickListener(View.OnClickListener {
            val dialog = CoordinatorWorkImageSelectionDialog()
            dialog.show(childFragmentManager, "ImageSelectionDialog")
        })

        binding.myPageWorkRevisionSaveButton.setOnClickListener(View.OnClickListener {
            Client.reviseWorkItem(workItem, position)
            backToMyPage()
        })

        binding.myPageWorkRevisionTagAddImg.setOnClickListener(View.OnClickListener {
            val dialog = TagSelectionDialog(this)
            dialog.show(childFragmentManager, "TagSelectionDialog")
        })
    }
    private fun setTextInit(){
        binding.myPageWorkRevisionDetailEditText.setText(workItem.deltail)
        binding.myPageWorkRevisionTopEditText.setText(workItem.top)
        binding.myPageWorkRevisionPantsEditText.setText(workItem.pants)
        binding.myPageWorkRevisionShoesEditText.setText(workItem.shoes)
    }

    private fun setEditTextLayout(){
        binding.myPageWorkRevisionDetailEditText.addTextChangedListener(textWatcher)
        binding.myPageWorkRevisionTopEditText.addTextChangedListener(textWatcher)
        binding.myPageWorkRevisionPantsEditText.addTextChangedListener(textWatcher)
        binding.myPageWorkRevisionShoesEditText.addTextChangedListener(textWatcher)
    }

    private fun backToMyPage(){
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageCoordinatorFragment(Client.getCoordinatorInfo(), 0))
        transaction.commit()
    }

    override fun setTags(tagTypes: MutableList<TagType>){
        workItem.tags = tagTypes
        tagAdapter.setDataSet(workItem.tags)
        binding.myPageWorkRevisionTagRecycler.adapter = tagAdapter
    }
}