package com.sigmai.stylemento.feature.mypage.user

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookBinding
import com.sigmai.stylemento.feature.mypage.user.adapter.UserLookbookAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageLookbookFragment(private val owner : User) : BaseFragment<FragmentMyPageLookbookBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lookbookAdapter = UserLookbookAdapter(owner, this)
        val gridLayoutManager = GridLayoutManager(context,3, GridLayoutManager.VERTICAL, false)

        lookbookAdapter.setDataSet(owner.lookbookItems)
        binding.myPageUserLookbookRecycler.adapter = lookbookAdapter
        binding.myPageUserLookbookRecycler.layoutManager = gridLayoutManager

        if(owner.email == Client.getUserInfo().email){
            binding.myPageUserLookbookAddImg.setOnClickListener(View.OnClickListener {
                val transaction = parentFragment?.parentFragmentManager?.beginTransaction()
                transaction?.replace(R.id.my_page_frameLayout, MyPageLookbookAddFragment())
                transaction?.commit()
            })
        }
        else{
            binding.myPageUserLookbookAddImg.visibility = View.GONE
        }
    }
}