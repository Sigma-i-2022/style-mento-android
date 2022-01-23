package com.sigmai.stylemento.feature.main

import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMainBinding
import com.sigmai.stylemento.feature.main.adapter.MainPagerAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val layoutResourceId = R.layout.fragment_main

    private val tabIcons = arrayListOf(R.drawable.tab_home, R.drawable.tab_clothes, R.drawable.tab_chat, R.drawable.tab_person)

    override fun initState() {
        super.initState()

        setViewPager()
        setBottomNavigation()
    }

    fun setViewPager() {
//        val tabs = view?.findViewById<TabLayout>(R.id.tabs)
//        val viewPager  = view?.findViewById<ViewPager2>(R.id.main_viewpager)
//        val pagerAdapter = MainPagerAdapter(this)
//
//        viewPager?.adapter = pagerAdapter
//        TabLayoutMediator(tabs!!, viewPager!!) { tab, position ->
//            tab.setIcon(tabIcons[position])
//        }.attach()
//
//        viewPager.isUserInputEnabled = false
    }

    fun setBottomNavigation() {
        val viewPager  = view?.findViewById<ViewPager2>(R.id.main_viewpager)
        val pagerAdapter = MainPagerAdapter(this)

        viewPager?.apply {
            adapter = pagerAdapter
            isUserInputEnabled = false
        }

        viewPager?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                binding.bottomNavigation.selectedItemId = when(position) {
                    0 -> R.id.page_home
                    1 -> R.id.page_coordinator
                    2 -> R.id.page_chat
                    3 -> R.id.page_my
                    else -> throw Exception("알 수 없는 탭입니다.")
                }
            }
        })

        binding.bottomNavigation.setOnNavigationItemSelectedListener { navigationSelected(it) }
    }

    private fun navigationSelected(item: MenuItem): Boolean {
        val checked = item.setChecked(true)
        return when (checked.itemId) {
            R.id.page_home -> {
                binding.mainViewpager.currentItem = 0
                true
            }
            R.id.page_coordinator -> {
                binding.mainViewpager.currentItem = 1
                true
            }
            R.id.page_chat -> {
                binding.mainViewpager.currentItem = 2
                true
            }
            R.id.page_my -> {
                binding.mainViewpager.currentItem = 3
                true
            }
            else -> false
        }
    }
}