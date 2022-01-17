package com.sigmai.stylemento.feature.mypage.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.feature.mypage.MyPageClosetFragment
import com.sigmai.stylemento.feature.mypage.MyPageLookbookFragment
import java.lang.Exception

class UserViewPagerAdapter(f : Fragment) : FragmentStateAdapter(f){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MyPageClosetFragment()
            1 -> MyPageLookbookFragment()
            else -> throw Exception("존재하지 않는 탭입니다.")
        }
    }

}