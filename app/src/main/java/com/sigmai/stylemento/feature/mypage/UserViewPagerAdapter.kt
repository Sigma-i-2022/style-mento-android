package com.sigmai.stylemento.feature.mypage

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class UserViewPagerAdapter(f : Fragment) : FragmentStateAdapter(f){
    var fragments = listOf<Fragment>()
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments.get(position)
    }
}