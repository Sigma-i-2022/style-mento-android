package com.sigmai.stylemento.feature.mypage.user

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookAddBinding
import com.sigmai.stylemento.feature.mypage.user.adapter.TagAdapter
import com.sigmai.stylemento.feature.mypage.user.dialog.*
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.constant.TagType

class MyPageLookbookAddFragment : BaseFragment<FragmentMyPageLookbookAddBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook_add

    private var tags : MutableList<TagType> = mutableListOf()
    private var lookbookItem : LookbookItem = LookbookItem(Client.getUserInfo().nickname, "", "", "", "", "", tags)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageLookbookAddBackImg.setOnClickListener(View.OnClickListener {
            backToMyPage()
        })

        binding.myPageLookbookAddItemImg.setOnClickListener(View.OnClickListener {
            val dialog = UserLookbookImageSelectionDialog()
            dialog.show(childFragmentManager, "ImageSelectionDialog")
        })

        setEditTextLayout()

        binding.myPageLookbookAddSaveButton.setOnClickListener(View.OnClickListener {
            Client.addLookbookItem(lookbookItem)
            backToMyPage()
        })

//        binding.myPageLookbookAddTagAddImg.setOnClickListener(View.OnClickListener {
//            val dialog = UserLookbookTagSelectionDialog(this)
//            dialog.show(childFragmentManager, "TagSelectionDialog")
//        })
    }

    private fun setEditTextLayout(){
        binding.myPageLookbookAddDetailEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                lookbookItem.deltail = p0.toString()
            }
        })
        binding.myPageLookbookAddTopEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                lookbookItem.top = p0.toString()
            }
        })
        binding.myPageLookbookAddPantsEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                lookbookItem.pants = p0.toString()
            }
        })
        binding.myPageLookbookAddShoesEditText.addTextChangedListener(object : TextWatcher {
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
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment(1))
        transaction.commit()
    }

    fun setTags(tagTypes: MutableList<TagType>){
        lookbookItem.tags = tagTypes
        val tagAdapter = TagAdapter()
        tagAdapter.setDataSet(lookbookItem.tags)
        binding.myPageLookbookAddTagRecycler.adapter = tagAdapter
    }
}
