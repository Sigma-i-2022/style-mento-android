package com.sigmai.stylemento.feature.main

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMainBinding
import com.sigmai.stylemento.global.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val layoutResourceId = R.layout.fragment_main

    private val outlinedIcons = arrayListOf(R.drawable.ic_tab_outlined_notification, R.drawable.ic_tab_outlined_coordinator,
        R.drawable.ic_tab_outlined_home, R.drawable.ic_tab_outlined_chat, R.drawable.ic_tab_outlined_my_page)
    private val filledIcons = arrayListOf(R.drawable.ic_tab_filled_notification, R.drawable.ic_tab_filled_coordinator,
        R.drawable.ic_tab_filled_home, R.drawable.ic_tab_filled_chat, R.drawable.ic_tab_fillted_my_page)

    override fun initState() {
        super.initState()

        setViewPager()
    }

    fun setViewPager() {
        val tabs = view?.findViewById<TabLayout>(R.id.tabs)
        val viewPager  = view?.findViewById<ViewPager2>(R.id.main_viewpager)
        val pagerAdapter = MainPagerAdapter(this)

        viewPager?.adapter = pagerAdapter
        TabLayoutMediator(tabs!!, viewPager!!) { tab, position ->
            tab.setIcon(outlinedIcons[position])
        }.attach()
    }
}