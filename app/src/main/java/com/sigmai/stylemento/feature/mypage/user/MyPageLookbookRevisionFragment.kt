package com.sigmai.stylemento.feature.mypage.user

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookRevisionBinding
import com.sigmai.stylemento.feature.mypage.TagAdapter
import com.sigmai.stylemento.feature.mypage.TagSelectionDialog
import com.sigmai.stylemento.feature.mypage.user.dialog.*
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.base.HavingTag
import com.sigmai.stylemento.global.constant.TagType

class MyPageLookbookRevisionFragment(private var lookbookItem : LookbookItem, private val position : Int)
    : BaseFragment<FragmentMyPageLookbookRevisionBinding>(), HavingTag {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook_revision

    private val tagAdapter = TagAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTextInit()
        tagAdapter.setDataSet(lookbookItem.tags)
        binding.myPageLookbookRevisionTagRecycler.adapter = tagAdapter

        setEditTextLayout()
        binding.myPageLookbookRevisionBackImg.setOnClickListener(View.OnClickListener {
            backToMyPage()
        })

        binding.myPageLookbookRevisionItemImg.setOnClickListener(View.OnClickListener {
            val dialog = UserLookbookImageSelectionDialog()
            dialog.show(childFragmentManager, "ImageSelectionDialog")
        })

        binding.myPageLookbookRevisionSaveButton.setOnClickListener(View.OnClickListener {
            Client.reviseLookbookItem(lookbookItem, position)
            backToMyPage()
        })

        binding.myPageLookbookRevisionTagAddImg.setOnClickListener(View.OnClickListener {
            val dialog = TagSelectionDialog(this)
            dialog.show(childFragmentManager, "TagSelectionDialog")
        })
    }
    private fun setTextInit(){
        binding.myPageLookbookRevisionDetailEditText.setText(lookbookItem.deltail)
        binding.myPageLookbookRevisionTopEditText.setText(lookbookItem.top)
        binding.myPageLookbookRevisionPantsEditText.setText(lookbookItem.pants)
        binding.myPageLookbookRevisionShoesEditText.setText(lookbookItem.shoes)
    }

    private fun setEditTextLayout(){
        binding.myPageLookbookRevisionDetailEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                lookbookItem.deltail = p0.toString()
            }
        })
        binding.myPageLookbookRevisionTopEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                lookbookItem.top = p0.toString()
            }
        })
        binding.myPageLookbookRevisionPantsEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                lookbookItem.pants = p0.toString()
            }
        })
        binding.myPageLookbookRevisionShoesEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                lookbookItem.shoes = p0.toString()
            }
        })
    }

    private fun backToMyPage(){
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment(Client.getUserInfo(), 1))
        transaction.commit()
    }

    override fun setTags(tagTypes: MutableList<TagType>){
        lookbookItem.tags = tagTypes
        tagAdapter.setDataSet(lookbookItem.tags)
        binding.myPageLookbookRevisionTagRecycler.adapter = tagAdapter
    }
}