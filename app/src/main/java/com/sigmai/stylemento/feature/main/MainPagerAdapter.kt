package com.sigmai.stylemento.feature.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.feature.host.ChatHostFragment
import com.sigmai.stylemento.feature.host.CoordinatorHostFragment
import com.sigmai.stylemento.feature.host.HomeHostFragment
import com.sigmai.stylemento.feature.host.MyPageHostFragment

class MainPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 5
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeHostFragment()
            1 -> CoordinatorHostFragment()
            2 -> HomeHostFragment()
            3 -> ChatHostFragment()
            4 -> MyPageHostFragment()
            else -> HomeHostFragment()
        }
    }
}