package com.sigmai.stylemento.ui.mypage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageBinding
import com.sigmai.stylemento.ui.mypage.user.MyPageUserFragment
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.coordinator.coordinatorpage.CoordinatorPageFragment

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

    private fun setMyPageFragment(){
        if(false){
            val transaction = childFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        else{
            val transaction = childFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, CoordinatorPageFragment(true))
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

}