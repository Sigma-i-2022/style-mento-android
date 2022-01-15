package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageUserRevisionBinding
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageRevisionFragment : BaseFragment<FragmentMyPageUserRevisionBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_user_revision

    val testDataSet = arrayOf("type1", "type2", "type3")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.myPageUserRevisionBackImg.setOnClickListener(View.OnClickListener {
            if(true){
                val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment())
                transaction.commit()
            }
            else{
                val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment())
                transaction.commit()
            }
        })
    }
}