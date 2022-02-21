package com.sigmai.stylemento.ui.coordinator_application

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ApplicationViewPagerAdapter(f: Fragment) : FragmentStateAdapter(f) {
    override fun getItemCount() = 2
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> FormFragment()
            1 -> SnsFragment()
            else -> throw Exception("UNKNOWN PAGE ERROR")
        }
    }
}