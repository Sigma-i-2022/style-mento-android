package com.sigmai.stylemento.feature.mypage.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageBinding
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageFragment : BaseFragment<FragmentMyPageBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page
    private val viewModel: MyPageViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setMyPageFragment()
    }

    public fun setMyPageFragment(){
        if(true){
            val transaction = childFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment(0))
            transaction.addToBackStack(null)
            transaction.commit()
        }
        else{ //coordinator my page로 수정
            val transaction = childFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment(0))
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

}