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

class MyPageUserFragment(private val owner : User, private val showMenu : Int) : BaseFragment<FragmentMyPageUserBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_user
    private val viewModel: MyPageViewModel by viewModels()
    val testDataSet = arrayOf("1", "2", "3", "4", "5")

    private var introductionState = 0

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val interestedAdapter = UserInterestedAdapter(testDataSet)

        binding.myPageUserInterestedRecycler.adapter = interestedAdapter

        val userAdapter = UserViewPagerAdapter(this, owner)
        binding.myPageUserViewPager.isUserInputEnabled = false
        if(showMenu == 0){
            userAdapter.setMenu(0)
            binding.myPageUserViewPager.adapter = userAdapter
            showCloset()
        }
        else if(showMenu == 1) {
            userAdapter.setMenu(1)
            binding.myPageUserViewPager.adapter = userAdapter
            showLookbook()
        }

        binding.myPageUserClosetButton.setOnClickListener(View.OnClickListener {
            showCloset()
        })
        binding.myPageUserLookbookButton.setOnClickListener(View.OnClickListener {
            showLookbook()
        })

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

    private fun showCloset(){
        if(showMenu == 0)
            binding.myPageUserViewPager.setCurrentItem(0, true)
        else
            binding.myPageUserViewPager.setCurrentItem(1, true)

        binding.myPageUserLookbookButton.setBackgroundResource(R.drawable.button_null)
        context?.let { it1 -> binding.myPageUserLookbookButton.setTextColor(it1.getColor(R.color.gray_d)) }
        binding.myPageUserClosetButton.setBackgroundResource(R.drawable.button_shadow)
        context?.let { it1 -> binding.myPageUserClosetButton.setTextColor(it1.getColor(R.color.black)) }
    }
    private fun showLookbook(){
        if(showMenu == 1)
            binding.myPageUserViewPager.setCurrentItem(0, true)
        else
            binding.myPageUserViewPager.setCurrentItem(1, true)

        binding.myPageUserClosetButton.setBackgroundResource(R.drawable.button_null)
        context?.let { it1 -> binding.myPageUserClosetButton.setTextColor(it1.getColor(R.color.gray_d)) }
        binding.myPageUserLookbookButton.setBackgroundResource(R.drawable.button_shadow)
        context?.let { it1 -> binding.myPageUserLookbookButton.setTextColor(it1.getColor(R.color.black)) }
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