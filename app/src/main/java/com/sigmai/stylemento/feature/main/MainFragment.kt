package com.sigmai.stylemento.feature.main

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMainBinding
import com.sigmai.stylemento.global.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val layoutResourceId = R.layout.fragment_main

    private val tabIcons = arrayListOf(R.drawable.tab_community, R.drawable.tab_clothes,
        R.drawable.tab_home, R.drawable.tab_chat, R.drawable.tab_person)

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
            tab.setIcon(tabIcons[position])
        }.attach()
    }
}