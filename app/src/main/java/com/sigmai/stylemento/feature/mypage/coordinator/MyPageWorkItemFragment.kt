package com.sigmai.stylemento.feature.mypage.coordinator

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.WorkItem
import com.sigmai.stylemento.databinding.FragmentMyPageWorkItemBinding
import com.sigmai.stylemento.feature.mypage.TagAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageWorkItemFragment(private val workItem : WorkItem, private val position : Int) : BaseFragment<FragmentMyPageWorkItemBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_work_item
    private var detailState = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageWorkBackImg.setOnClickListener(View.OnClickListener {
            val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageCoordinatorFragment(0))
            transaction.commit()
        })

        dataBinding()
        setOnClickDetail()
    }

    private fun dataBinding(){
        binding.myPageWorkItemImg.setImageResource(R.drawable.ic_launcher_foreground)
        binding.myPageWorkItemDetail.text = workItem.deltail
        binding.myPageWorkItemTopText.text = workItem.top
        binding.myPageWorkItemPantsText.text = workItem.pants
        binding.myPageWorkItemShoesText.text = workItem.shoes

        val workTagAdapter = TagAdapter()
        workTagAdapter.setDataSet(workItem.tags)
        binding.myPageWorkItemTagRecycler.adapter = workTagAdapter

        binding.myPageWorkItemRevision.setOnClickListener(View.OnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.my_page_frameLayout, MyPageWorkRevisionFragment(workItem.copy(), position))
            transaction.commit()
        })

        binding.myPageWorkItemDelete.setOnClickListener(View.OnClickListener {
            var builder = AlertDialog.Builder(context)
            builder.setMessage("이 아이템을 삭제 하시겠습니까?")

            var listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            Client.removeWorkItem(position)
                            val transaction = parentFragmentManager.beginTransaction()
                            transaction.replace(R.id.my_page_frameLayout, MyPageCoordinatorFragment(0))
                            transaction.commit()
                        }
                    }
                }
            }

            builder.setPositiveButton("삭제", listener)
            builder.setNegativeButton("취소", listener)

            builder.show()
        })
    }
    private fun setOnClickDetail(){
        binding.myPageWorkItemDetail.setOnClickListener(View.OnClickListener {
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
}