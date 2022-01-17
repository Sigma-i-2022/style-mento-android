package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageClosetAddBinding
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageClosetAddFragment : BaseFragment<FragmentMyPageClosetAddBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_closet_add


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageClosetAddBackImg.setOnClickListener(View.OnClickListener {
            backToMyPage()
        })
        binding.myPageClosetAddImgSelectionLayout.visibility = View.GONE
    }

    private fun backToMyPage(){
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment())
        transaction.commit()
    }
}