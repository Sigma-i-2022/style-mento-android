package com.sigmai.stylemento.ui.mypage.coordinator

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.WorkItem
import com.sigmai.stylemento.databinding.FragmentMyPageWorkItemBinding
import com.sigmai.stylemento.domain.usecase.GetWorkItemUseCase
import com.sigmai.stylemento.ui.mypage.TagAdapter
import com.sigmai.stylemento.ui.mypage.coordinator.viewModel.MyPageWorkItemViewModel
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageWorkItemFragment() : BaseFragment<FragmentMyPageWorkItemBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_work_item
    private val viewModel: MyPageWorkItemViewModel by viewModels()
    private var detailState = 0
    private var position: Int = 0

    private lateinit var workItem : WorkItem
    private val getWorkItemUseCase = GetWorkItemUseCase()
    override fun initState() {
        super.initState()
        position = arguments?.getInt("position")!!
        workItem = getWorkItemUseCase(position)
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this, {
            findNavController().navigateUp()
        })
        viewModel.startRevision.observe(this, {
            val bundle = bundleOf("position" to position)
        })
        viewModel.startDelete.observe(this, {
            setDeleteDialog()
        })
        viewModel.startInstruction.observe(this, {
            if(detailState == 0){
                binding.myPageWorkItemDetail.maxLines = 10
                detailState = 1
            }
            else{
                binding.myPageWorkItemDetail.maxLines = 2
                detailState = 0
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this).load(workItem.photoUrl).into(binding.myPageWorkItemImg)
        binding.myPageWorkItemDetail.text = workItem.detail
        binding.myPageWorkItemTopText.text = workItem.top
        binding.myPageWorkItemPantsText.text = workItem.pants
        binding.myPageWorkItemShoesText.text = workItem.shoes
        binding.myPageWorkItemTimeText.text = workItem.time

        val workTagAdapter = TagAdapter()
        workTagAdapter.setDataSet(workItem.tags)
        binding.myPageWorkItemTagRecycler.adapter = workTagAdapter
    }

    private fun setDeleteDialog() {
        var builder = AlertDialog.Builder(context)
        builder.setMessage("이 아이템을 삭제 하시겠습니까?")

        var listener = object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                when (p1) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        Client.removeWorkItem(position)
                        findNavController().popBackStack()
                    }
                }
            }
        }

        builder.setPositiveButton("삭제", listener)
        builder.setNegativeButton("취소", listener)

        builder.show()
    }
}