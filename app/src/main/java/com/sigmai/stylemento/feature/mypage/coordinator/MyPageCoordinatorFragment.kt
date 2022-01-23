package com.sigmai.stylemento.feature.mypage.coordinator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.databinding.FragmentMyPageCoordinatorBinding
import com.sigmai.stylemento.feature.mypage.MyPageViewModel
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageCoordinatorFragment(private val showMenu : Int) : BaseFragment<FragmentMyPageCoordinatorBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_coordinator
    private val viewModel: MyPageViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /*val userAdapter = UserViewPagerAdapter(this)
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
        }*/

        binding.myPageCoordinatorWorkButton.setOnClickListener(View.OnClickListener {
            showWork()
        })
        binding.myPageCoordinatorReviewsButton.setOnClickListener(View.OnClickListener {
            showReview()
        })

        binding.myPageCoordiantorRevisionImg.setOnClickListener(View.OnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.my_page_frameLayout, MyPageCoordinatorRevisionFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        })

        binding.myPageCoordinatorNameText.text = Client.getCoordinatorInfo().nickname
        binding.myPageCoordinatorEmailText.text = Client.getCoordinatorInfo().email
        binding.myPageCoordinatorIntroductionText.text = Client.getCoordinatorInfo().introduction

    }

    private fun showWork(){
        /*if(showMenu == 0)
            binding.myPageUserViewPager.setCurrentItem(0, true)
        else
            binding.myPageUserViewPager.setCurrentItem(1, true)

        binding.myPageUserLookbookButton.setBackgroundResource(R.drawable.button_null)
        context?.let { it1 -> binding.myPageUserLookbookButton.setTextColor(it1.getColor(R.color.gray_d)) }
        binding.myPageUserClosetButton.setBackgroundResource(R.drawable.button_shadow)
        context?.let { it1 -> binding.myPageUserClosetButton.setTextColor(it1.getColor(R.color.black)) }*/
    }
    private fun showReview(){
        /*if(showMenu == 1)
            binding.myPageUserViewPager.setCurrentItem(0, true)
        else
            binding.myPageUserViewPager.setCurrentItem(1, true)

        binding.myPageUserClosetButton.setBackgroundResource(R.drawable.button_null)
        context?.let { it1 -> binding.myPageUserClosetButton.setTextColor(it1.getColor(R.color.gray_d)) }
        binding.myPageUserLookbookButton.setBackgroundResource(R.drawable.button_shadow)
        context?.let { it1 -> binding.myPageUserLookbookButton.setTextColor(it1.getColor(R.color.black)) }*/
    }
}