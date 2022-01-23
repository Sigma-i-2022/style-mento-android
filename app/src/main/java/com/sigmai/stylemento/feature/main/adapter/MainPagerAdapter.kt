package com.sigmai.stylemento.feature.main.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.feature.home.HomeFragment
import com.sigmai.stylemento.feature.host.ChatHostFragment
import com.sigmai.stylemento.feature.host.CoordinatorHostFragment
import com.sigmai.stylemento.feature.host.HomeHostFragment
import com.sigmai.stylemento.feature.host.MyPageHostFragment
import java.lang.Exception

class MainPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 4
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> CoordinatorHostFragment()
            2 -> ChatHostFragment()
            3 -> MyPageHostFragment()
            else -> throw Exception("존재하지 않는 탭입니다.")
        }
    }
}