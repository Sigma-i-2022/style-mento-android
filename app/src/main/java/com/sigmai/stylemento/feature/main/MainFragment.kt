package com.sigmai.stylemento.feature.main

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMainBinding
import com.sigmai.stylemento.global.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val layoutResourceId = R.layout.fragment_main
    override fun initState() {
        super.initState()

        setViewPager()
    }

    fun setViewPager() {
        val viewPager  = view?.findViewById<ViewPager2>(R.id.main_viewpager)
        val pagerAdapter = MainPagerAdapter(this)

        viewPager?.adapter = pagerAdapter
    }
}