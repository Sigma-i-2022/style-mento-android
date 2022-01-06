package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageBinding
import com.sigmai.stylemento.global.base.BaseFragment
import kotlin.math.log

class MyPageFragment : BaseFragment<FragmentMyPageBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page
    private val viewModel: MyPageViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userViewPager : ViewPager2 = view.findViewById(R.id.user_viewPager)
        val userAdapter = UserViewPagerAdapter(this)
        userViewPager.adapter = userAdapter

        val closetButton : TextView = view.findViewById(R.id.my_page_closet_button)
        val lookbookButton : TextView = view.findViewById(R.id.my_page_lookbook_button)
        closetButton.setOnClickListener(View.OnClickListener {
            userViewPager.setCurrentItem(0, true)
            lookbookButton.setBackgroundResource(R.drawable.button_null)
            closetButton.setBackgroundResource(R.drawable.button_shadow)
        })
        lookbookButton.setOnClickListener(View.OnClickListener {
            userViewPager.setCurrentItem(1, true)
            lookbookButton.setBackgroundResource(R.drawable.button_shadow)
            closetButton.setBackgroundResource(R.drawable.button_null)
        })
    }
}