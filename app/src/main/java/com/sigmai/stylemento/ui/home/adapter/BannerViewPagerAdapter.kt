package com.sigmai.stylemento.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.R
import com.sigmai.stylemento.generated.callback.OnClickListener
import com.sigmai.stylemento.ui.home.BannerFragment
import com.sigmai.stylemento.ui.main.MainViewModel
import com.sigmai.stylemento.ui.mypage.coordinator.CoordinatorPageWorkFragment
import com.sigmai.stylemento.ui.mypage.coordinator.MyPageReviewFragment
import java.lang.Exception

class BannerViewPagerAdapter(f : Fragment) : FragmentStateAdapter(f){
    override fun getItemCount(): Int = 7

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> BannerFragment(R.drawable.ic_logo, 0) // 임시 이미지와 액션
            1 -> BannerFragment(R.drawable.ic_logo, 1)
            2 -> BannerFragment(R.drawable.ic_logo, 2)
            3 -> BannerFragment(R.drawable.ic_logo, 3)
            4 -> BannerFragment(R.drawable.ic_logo, 4)
            5 -> BannerFragment(R.drawable.ic_logo, 5)
            6 -> BannerFragment(R.drawable.ic_logo, 6)
            else -> throw Exception("FragmentStateAdapter, 잘못된 position 입니다.")
        }
    }
}