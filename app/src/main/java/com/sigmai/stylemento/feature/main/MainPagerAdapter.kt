package com.sigmai.stylemento.feature.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.feature.coordinator.CoordinatorHostFragment
import com.sigmai.stylemento.feature.home.HomeFragment
import com.sigmai.stylemento.feature.home.HomeHostFragment

class MainPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 5
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeHostFragment()
            1 -> HomeHostFragment()
            2 -> HomeHostFragment()
            3 -> HomeHostFragment()
            4 -> HomeHostFragment()
            else -> HomeHostFragment()
        }
    }
}