package com.sigmai.stylemento.feature.mypage.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageUserBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.feature.mypage.user.adapter.UserViewPagerAdapter

class MyPageUserFragment : BaseFragment<FragmentMyPageUserBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_user
    private val viewModel: MyPageUserViewModel by viewModels()

    private var introductionState = 0

    override fun initState() {
        super.initState()
        viewModel.getUserInfo()
    }
    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startRevision.observe(this, {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.my_page_frameLayout, MyPageUserRevisionFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        })
        viewModel.startInstruction.observe(this, {
            if(introductionState == 0){
                binding.myPageUserIntroductionText.maxLines = 10
                introductionState = 1
            }
            else{
                binding.myPageUserIntroductionText.maxLines = 3
                introductionState = 0
            }
        })
        binding.myPageUserChatButton.visibility = View.GONE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userAdapter = UserViewPagerAdapter(this)
        binding.myPageUserViewPager.isUserInputEnabled = false
        binding.myPageUserViewPager.adapter = userAdapter
    }
}