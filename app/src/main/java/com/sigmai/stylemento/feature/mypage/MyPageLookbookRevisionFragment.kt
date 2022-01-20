package com.sigmai.stylemento.feature.mypage

import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.ClosetItem
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.databinding.FragmentMyPageClosetAddBinding
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookAddBinding
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookRevisionBinding
import com.sigmai.stylemento.feature.mypage.adapter.TagAdapter
import com.sigmai.stylemento.feature.mypage.dialog.*
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TagType
import com.sigmai.stylemento.global.constant.TextureType
import com.sigmai.stylemento.global.util.TransformToEnumUtil
import com.sigmai.stylemento.global.util.TransformToStringUtil

class MyPageLookbookRevisionFragment(private var lookbookItem : LookbookItem, private val position : Int) : BaseFragment<FragmentMyPageLookbookRevisionBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook_revision

    private var tags : MutableList<TagType> = mutableListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTextInit()
        val tagAdapter = TagAdapter()
        tagAdapter.setDataSet(lookbookItem.tags)
        binding.myPageLookbookRevisionTagRecycler.adapter = tagAdapter

        setEditTextLayout()
        binding.myPageLookbookRevisionBackImg.setOnClickListener(View.OnClickListener {
            backToMyPage()
        })

        binding.myPageLookbookRevisionSaveButton.setOnClickListener(View.OnClickListener {
            Client.addLookbookItem(lookbookItem)
            backToMyPage()
        })

        binding.myPageLookbookRevisionTagAddImg.setOnClickListener(View.OnClickListener {
            val dialog = UserLookbookTagSelectionDialog(this)
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
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageLookbookFragment())
        transaction.commit()
    }

    fun setTags(tagTypes: MutableList<TagType>){
        lookbookItem.tags = tagTypes
        val tagAdapter = TagAdapter()
        tagAdapter.setDataSet(lookbookItem.tags)
        binding.myPageLookbookRevisionTagRecycler.adapter = tagAdapter
    }
}