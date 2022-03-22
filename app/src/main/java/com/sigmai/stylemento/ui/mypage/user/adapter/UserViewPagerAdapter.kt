package com.sigmai.stylemento.ui.mypage.user.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.ui.mypage.user.MyPageLookbookFragment

class UserViewPagerAdapter(f : Fragment) : FragmentStateAdapter(f){
    override fun getItemCount(): Int = 1

    override fun createFragment(position: Int): Fragment {
        return MyPageLookbookFragment()
    }
}