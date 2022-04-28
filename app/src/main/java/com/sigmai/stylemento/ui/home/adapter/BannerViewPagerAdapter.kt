package com.sigmai.stylemento.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.R
import com.sigmai.stylemento.ui.home.BannerFragment

class BannerViewPagerAdapter(f: Fragment) : FragmentStateAdapter(f) {
    private val bannerResourceMapping = arrayListOf(
        R.drawable.banner_client_1,
        R.drawable.banner_client_2,
        R.drawable.banner_client_3,
        R.drawable.banner_coordinator_1,
        R.drawable.banner_coordinator_2,
        R.drawable.banner_coordinator_3,
        R.drawable.banner_coordinator_4
    )

    override fun getItemCount(): Int = bannerResourceMapping.size

    override fun createFragment(position: Int): Fragment {
        if(position < 0 || position >= itemCount) throw Exception("FragmentStateAdapter, 잘못된 position 입니다.")

        return BannerFragment(bannerResourceMapping[position], position)
    }
}