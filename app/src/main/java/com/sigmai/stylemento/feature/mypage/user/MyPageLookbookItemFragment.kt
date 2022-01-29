package com.sigmai.stylemento.feature.mypage.user

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookItemBinding
import com.sigmai.stylemento.feature.mypage.TagAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageLookbookItemFragment(private val owner : User, private val position : Int) : BaseFragment<FragmentMyPageLookbookItemBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook_item
    private var detailState = 0
    private val lookbookItem = owner.lookbookItems.get(position)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding()
        if(owner.email != Client.getUserInfo().email){
            binding.myPageUserLookbookItemRevision.visibility = View.GONE
            binding.myPageUserLookbookItemDelete.visibility = View.GONE
            binding.myPageUserLookbookBackImg.setOnClickListener(View.OnClickListener {
                val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment(owner, 1))
                transaction.commit()
            })
        }
        else
            sameOwnerInit()
    }

    private fun dataBinding(){
        binding.myPageUserLookbookItemImg.setImageResource(R.drawable.ic_launcher_foreground)
        binding.myPageUserLookbookItemDetail.text = lookbookItem.deltail
        binding.myPageLookbookItemTopText.text = lookbookItem.top
        binding.myPageLookbookItemPantsText.text = lookbookItem.pants
        binding.myPageLookbookItemShoesText.text = lookbookItem.shoes
        binding.myPageLookbookItemTimeText.text = lookbookItem.time

        val lookbookTagAdapter = TagAdapter()
        lookbookTagAdapter.setDataSet(lookbookItem.tags)
        binding.myPageUserLookbookItemTagRecycler.adapter = lookbookTagAdapter

        binding.myPageUserLookbookItemCoordiInfoText.setOnClickListener(View.OnClickListener {
            setOnClickIntroduction()
        })
    }

    private fun sameOwnerInit(){
        binding.myPageUserLookbookBackImg.setOnClickListener(View.OnClickListener {
            val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment(Client.getUserInfo(), 1))
            transaction.commit()
        })

        binding.myPageUserLookbookItemRevision.setOnClickListener(View.OnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.my_page_frameLayout, MyPageLookbookRevisionFragment(lookbookItem.copy(), position))
            transaction.commit()
        })

        binding.myPageUserLookbookItemDelete.setOnClickListener(View.OnClickListener {
            var builder = AlertDialog.Builder(context)
            builder.setMessage("이 아이템을 삭제 하시겠습니까?")

            var listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            Client.removeLookbookItem(position)
                            val transaction = parentFragmentManager.beginTransaction()
                            transaction.replace(R.id.my_page_frameLayout, MyPageUserFragment(Client.getUserInfo(), 1))
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
    private fun setOnClickIntroduction(){
        binding.myPageUserLookbookItemDetail.setOnClickListener(View.OnClickListener {
            if(detailState == 0){
                binding.myPageUserLookbookItemDetail.maxLines = 10
                detailState = 1
            }
            else{
                binding.myPageUserLookbookItemDetail.maxLines = 2
                detailState = 0
            }
        })
    }
}