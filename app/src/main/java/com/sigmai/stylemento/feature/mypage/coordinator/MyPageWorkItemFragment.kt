package com.sigmai.stylemento.feature.mypage.coordinator

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.data.model.WorkItem
import com.sigmai.stylemento.databinding.FragmentMyPageWorkItemBinding
import com.sigmai.stylemento.feature.mypage.TagAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageWorkItemFragment(private val owner : Coordinator, private val position : Int) : BaseFragment<FragmentMyPageWorkItemBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_work_item
    private var workItem = owner.workItems.get(position)
    private var detailState = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding()
        setOnClickDetail()
    }
    private fun ownerCheck(){
        if(owner.email == Client.getCoordinatorInfo().email){
            binding.myPageWorkBackImg.setOnClickListener(View.OnClickListener {
                val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageCoordinatorFragment(Client.getCoordinatorInfo(), 0))
                transaction.commit()
            })

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
                                transaction.replace(R.id.my_page_frameLayout, MyPageCoordinatorFragment(Client.getCoordinatorInfo(), 0))
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
        else{
            binding.myPageWorkBackImg.setOnClickListener(View.OnClickListener {
                val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageCoordinatorFragment(owner, 0))
                transaction.commit()
            })

            binding.myPageWorkItemRevision.visibility = View.GONE
            binding.myPageWorkItemDelete.visibility = View.GONE
        }
    }
    private fun dataBinding(){
        binding.myPageWorkItemImg.setImageResource(R.drawable.ic_launcher_foreground)
        binding.myPageWorkItemDetail.text = workItem.deltail
        binding.myPageWorkItemTopText.text = workItem.top
        binding.myPageWorkItemPantsText.text = workItem.pants
        binding.myPageWorkItemShoesText.text = workItem.shoes
        binding.myPageWorkItemTimeText.text = workItem.time

        val workTagAdapter = TagAdapter()
        workTagAdapter.setDataSet(workItem.tags)
        binding.myPageWorkItemTagRecycler.adapter = workTagAdapter
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