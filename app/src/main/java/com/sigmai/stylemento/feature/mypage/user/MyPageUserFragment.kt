package com.sigmai.stylemento.feature.mypage.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.databinding.FragmentMyPageUserBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.feature.mypage.MyPageViewModel
import com.sigmai.stylemento.feature.mypage.user.adapter.UserInterestedAdapter
import com.sigmai.stylemento.feature.mypage.user.adapter.UserViewPagerAdapter

class MyPageUserFragment(private val owner : User) : BaseFragment<FragmentMyPageUserBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_user
    private val viewModel: MyPageViewModel by viewModels()

    private var introductionState = 0

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userAdapter = UserViewPagerAdapter(this, owner)
        binding.myPageUserViewPager.isUserInputEnabled = false


        binding.myPageUserViewPager.adapter = userAdapter

        binding.myPageUserNameText.text = owner.nickname
        binding.myPageUserEmailText.text = owner.email
        binding.myPageUserIntroductionText.text = owner.introduction
        binding.myPageUserIntroductionText.setOnClickListener(View.OnClickListener {
            setOnClickIntroduction()
        })

        ownerCheck()
    }

    private fun ownerCheck(){
        if(owner.email == Client.getUserInfo().email){
            binding.myPageUserReviseImg.setOnClickListener(View.OnClickListener {
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.my_page_frameLayout, MyPageUserRevisionFragment())
                transaction.addToBackStack(null)
                transaction.commit()
            })
        }
        else{
            binding.myPageUserReviseImg.visibility = View.GONE
            binding.myPageUserChatButton.visibility = View.GONE
        }
    }

    private fun setOnClickIntroduction(){
        binding.myPageUserIntroductionText.setOnClickListener(View.OnClickListener {
            if(introductionState == 0){
                binding.myPageUserIntroductionText.maxLines = 10
                introductionState = 1
            }
            else{
                binding.myPageUserIntroductionText.maxLines = 3
                introductionState = 0
            }
        })
    }
}