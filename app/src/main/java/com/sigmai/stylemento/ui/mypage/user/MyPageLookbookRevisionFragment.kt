package com.sigmai.stylemento.ui.mypage.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookRevisionBinding
import com.sigmai.stylemento.ui.mypage.TagAdapter
import com.sigmai.stylemento.ui.mypage.TagSelectionDialog
import com.sigmai.stylemento.ui.mypage.user.dialog.*
import com.sigmai.stylemento.ui.mypage.user.viewModel.MyPageLookbookRevisionViewModel
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.base.HavingTag
import com.sigmai.stylemento.global.constant.TagType
import java.text.SimpleDateFormat

class MyPageLookbookRevisionFragment(private val position : Int)
    : BaseFragment<FragmentMyPageLookbookRevisionBinding>(), HavingTag {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook_revision
    private val viewModel: MyPageLookbookRevisionViewModel by viewModels()
    private var lookbookItem = Client.getUserInfo().lookbookItems[position].copy()

    private val tagAdapter = TagAdapter()
    override fun initState() {
        super.initState()
        viewModel.setItemInfo(lookbookItem)
    }
    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
        viewModel.startBack.observe(this, {
            backToMyPage()
        })
        viewModel.startSave.observe(this, {
            setTime()
            Client.reviseLookbookItem(lookbookItem, position)
            backToMyPage()
        })
        viewModel.startTagAdd.observe(this, {
            val dialog = TagSelectionDialog(this)
            dialog.show(childFragmentManager, "TagSelectionDialog")
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tagAdapter.setDataSet(lookbookItem.tags)
        binding.myPageLookbookRevisionTagRecycler.adapter = tagAdapter

        setEditTextLayout()

        binding.myPageLookbookRevisionItemImg.setOnClickListener(View.OnClickListener {
            val dialog = UserLookbookImageSelectionDialog()
            dialog.show(childFragmentManager, "ImageSelectionDialog")
        })
    }

    private fun setEditTextLayout(){
        binding.myPageLookbookRevisionDetailEditText.addTextChangedListener(AdditionPageTextWatcher(lookbookItem, "detail"))
        binding.myPageLookbookRevisionTopEditText.addTextChangedListener(AdditionPageTextWatcher(lookbookItem, "top"))
        binding.myPageLookbookRevisionPantsEditText.addTextChangedListener(AdditionPageTextWatcher(lookbookItem, "pants"))
        binding.myPageLookbookRevisionShoesEditText.addTextChangedListener(AdditionPageTextWatcher(lookbookItem, "shoes"))
    }

    private fun setTime(){
        val currentTime : Long = System.currentTimeMillis()
        val dataFormat = SimpleDateFormat("yyyy-MM-dd")
        lookbookItem.time = dataFormat.format(currentTime)
    }

    private fun backToMyPage(){
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment())
        transaction.commit()
    }

    override fun setTags(tagTypes: MutableList<TagType>){
        lookbookItem.tags = tagTypes
        tagAdapter.setDataSet(tagTypes)
        binding.myPageLookbookRevisionTagRecycler.adapter = tagAdapter
    }
}