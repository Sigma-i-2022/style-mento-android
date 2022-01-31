package com.sigmai.stylemento.feature.mypage.coordinator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.databinding.FragmentMyPageCoordinatorRevisionBinding
import com.sigmai.stylemento.feature.mypage.coordinator.dialog.CoordinatorImageSelectionDialog
import com.sigmai.stylemento.feature.mypage.TagAdapter
import com.sigmai.stylemento.feature.mypage.TagSelectionDialog
import com.sigmai.stylemento.global.base.HavingTag
import com.sigmai.stylemento.global.constant.TagType

class MyPageCoordinatorRevisionFragment : BaseFragment<FragmentMyPageCoordinatorRevisionBinding>(), HavingTag {
    override val layoutResourceId = R.layout.fragment_my_page_coordinator_revision

    private var tags : MutableList<TagType> = mutableListOf()
    private val tagAdapter = TagAdapter()

    private var introductionText : String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.myPageCoordinatorRevisionBackImg.setOnClickListener(View.OnClickListener {
            backToMyPage()
        })

        binding.myPageCoordinatorRevisionProfileImg.setOnClickListener(View.OnClickListener {
            val dialog = CoordinatorImageSelectionDialog()
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

        binding.myPageCoordinatorRevisionSaveButton.setOnClickListener(View.OnClickListener {
            Client.getCoordinatorInfo().introduction = introductionText
            Client.getCoordinatorInfo().styleTags = tags
            backToMyPage()
        })

        binding.myPageCoordinatorRevisionStyleTagAdd.setOnClickListener(View.OnClickListener {
            val dialog = TagSelectionDialog(this)
            dialog.show(childFragmentManager, "TagSelectionDialog")
        })

        tagAdapter.setDataSet(Client.getCoordinatorInfo().styleTags)
        binding.myPageCoordinatorRevisionStyleTagRecyclerView.adapter = tagAdapter
    }
    private fun backToMyPage(){
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageCoordinatorFragment(Client.getCoordinatorInfo(), 0))
        transaction.commit()
    }
    override fun setTags(tagTypes: MutableList<TagType>){
        tags = tagTypes
        tagAdapter.setDataSet(tags)
        binding.myPageCoordinatorRevisionStyleTagRecyclerView.adapter = tagAdapter
    }
}