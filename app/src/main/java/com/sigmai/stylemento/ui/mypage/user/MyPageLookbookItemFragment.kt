package com.sigmai.stylemento.ui.mypage.user

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
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookItemBinding
import com.sigmai.stylemento.domain.usecase.GetLookbookItemUseCase
import com.sigmai.stylemento.ui.mypage.TagAdapter
import com.sigmai.stylemento.ui.mypage.user.viewModel.MyPageLookbookItemViewModel
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageLookbookItemFragment() : BaseFragment<FragmentMyPageLookbookItemBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook_item
    private val viewModel: MyPageLookbookItemViewModel by viewModels()
    private var position: Int = 0

    private var detailState = 0

    override fun initState() {
        super.initState()
        position = arguments?.getInt("position")!!
        viewModel.setItemInfo(position)
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this, {
            findNavController().navigateUp()
        })
        viewModel.startRevision.observe(this, {
            val bundle = bundleOf("position" to position)
            findNavController().navigate(R.id.action_lookbook_item_to_lookbook_add, bundle)
        })
        viewModel.startDelete.observe(this, {
            setDeleteDialog()
        })
        viewModel.startInstruction.observe(this, {
            if (detailState == 0) {
                binding.myPageUserLookbookItemDetail.maxLines = 10
                detailState = 1
            } else {
                binding.myPageUserLookbookItemDetail.maxLines = 2
                detailState = 0
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this).load(viewModel.item.value?.photoUrl).into(binding.myPageUserLookbookItemImg)

        val lookbookTagAdapter = TagAdapter()
        lookbookTagAdapter.setDataSet(viewModel.item.value?.tags)
        binding.myPageUserLookbookItemTagRecycler.adapter = lookbookTagAdapter
    }

    private fun setDeleteDialog() {
        var builder = AlertDialog.Builder(context)
        builder.setMessage("이 아이템을 삭제 하시겠습니까?")

        var listener = object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                when (p1) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        Client.removeLookbookItem(position)
                        findNavController().navigateUp()
                    }
                }
            }
        }

        builder.setPositiveButton("삭제", listener)
        builder.setNegativeButton("취소", listener)

        builder.show()
    }
}