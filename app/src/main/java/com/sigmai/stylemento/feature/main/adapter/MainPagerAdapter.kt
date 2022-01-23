package com.sigmai.stylemento.feature.main.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.feature.chat.ChatFragment
import com.sigmai.stylemento.feature.coordinator.CoordinatorFragment
import com.sigmai.stylemento.feature.home.HomeFragment
import com.sigmai.stylemento.feature.host.ChatHostFragment
import com.sigmai.stylemento.feature.host.CoordinatorHostFragment
import com.sigmai.stylemento.feature.host.HomeHostFragment
import com.sigmai.stylemento.feature.host.MyPageHostFragment
import com.sigmai.stylemento.feature.mypage.user.MyPageFragment
import java.lang.Exception

class MainPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 4
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> CoordinatorFragment()
            2 -> ChatFragment()
            3 -> MyPageFragment()
            else -> throw Exception("존재하지 않는 탭입니다.")
        }
    }
}