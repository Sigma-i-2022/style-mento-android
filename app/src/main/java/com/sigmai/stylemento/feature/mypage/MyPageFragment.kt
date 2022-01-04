package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageBinding
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageFragment : BaseFragment<FragmentMyPageBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page
    private val viewModel: MyPageViewModel by viewModels()
    private val fragmentList = listOf<Fragment>(MyPageClosetFragment(), MyPageLookbookFragment())

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_my_page, container, false)

        val userViewPager : ViewPager2 = v.findViewById(R.id.user_viewPager)
        val userAdapter = UserViewPagerAdapter(this)
        userAdapter.fragments = fragmentList
        userViewPager.adapter = userAdapter

        return v
    }
}