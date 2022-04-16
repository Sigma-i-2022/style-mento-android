package com.sigmai.stylemento.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.R
import com.sigmai.stylemento.generated.callback.OnClickListener
import com.sigmai.stylemento.ui.home.BannerFragment
import com.sigmai.stylemento.ui.mypage.coordinator.CoordinatorPageWorkFragment
import com.sigmai.stylemento.ui.mypage.coordinator.MyPageReviewFragment
import java.lang.Exception

class BannerViewPagerAdapter(f : Fragment) : FragmentStateAdapter(f){
    override fun getItemCount(): Int = 7

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> BannerFragment(0, R.id.action_application_finish_to_main) // 임시 이미지와 액션
            1 -> BannerFragment(0, R.id.action_application_finish_to_main)
            2 -> BannerFragment(0, R.id.action_application_finish_to_main)
            3 -> BannerFragment(0, R.id.action_application_finish_to_main)
            4 -> BannerFragment(0, R.id.action_application_finish_to_main)
            5 -> BannerFragment(0, R.id.action_application_finish_to_main)
            6 -> BannerFragment(0, R.id.action_application_finish_to_main)
            else -> throw Exception("FragmentStateAdapter, 잘못된 position 입니다.")
        }
    }
}