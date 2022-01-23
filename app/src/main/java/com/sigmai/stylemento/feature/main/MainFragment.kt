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
    private val pages = listOf(R.id.page_home, R.id.page_coordinator, R.id.page_chat, R.id.page_my)
    private val positions = mapOf(
        R.id.page_home to 0,
        R.id.page_coordinator to 1,
        R.id.page_chat to 2,
        R.id.page_my to 3)

    override fun initState() {
        super.initState()

        setBottomNavigation()
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

                binding.bottomNavigation.selectedItemId = pages[position]
            }
        })

        binding.bottomNavigation.setOnNavigationItemSelectedListener { navigationSelected(it) }
    }

    private fun navigationSelected(item: MenuItem): Boolean {
        item.isChecked = true

        binding.mainViewpager.currentItem = positions[item.itemId] ?: throw Exception("알 수 없는 탭입니다.")

        return true
    }
}