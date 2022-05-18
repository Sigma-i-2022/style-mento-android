package com.sigmai.stylemento.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.ui.chat.ChatFragment
import com.sigmai.stylemento.ui.coordinator.CoordinatorFragment
import com.sigmai.stylemento.ui.home.HomeFragment
import com.sigmai.stylemento.ui.mypage.MyPageFragment
import java.lang.Exception

class MainPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> CoordinatorFragment()
            2 -> MyPageFragment()
            else -> throw Exception("존재하지 않는 탭입니다.")
        }
    }
}