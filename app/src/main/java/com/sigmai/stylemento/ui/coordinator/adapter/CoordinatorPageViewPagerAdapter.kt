package com.sigmai.stylemento.ui.coordinator.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.ui.coordinator.CoordinatorPageWorkFragment
import com.sigmai.stylemento.ui.mypage.coordinator.MyPageReviewFragment
import com.sigmai.stylemento.ui.mypage.coordinator.MyPageWorkFragment
import java.lang.Exception

class CoordinatorPageViewPagerAdapter(f : Fragment) : FragmentStateAdapter(f){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> CoordinatorPageWorkFragment()
            1 -> MyPageReviewFragment()
            else -> throw Exception("FragmentStateAdapter, 잘못된 position 입니다.")
        }
    }
}