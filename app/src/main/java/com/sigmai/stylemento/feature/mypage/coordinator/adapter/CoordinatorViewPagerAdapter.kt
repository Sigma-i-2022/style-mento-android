package com.sigmai.stylemento.feature.mypage.coordinator.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.feature.mypage.coordinator.MyPageReviewFragment
import com.sigmai.stylemento.feature.mypage.coordinator.MyPageWorkFragment
import java.lang.Exception

class CoordinatorViewPagerAdapter(f : Fragment) : FragmentStateAdapter(f){
    private var menu : Int = 0
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if(menu == 0){
            when(position) {
                0 -> MyPageWorkFragment()
                1 -> MyPageReviewFragment()
                else -> throw Exception("존재하지 않는 탭입니다.")
            }
        } else{
            when(position) {
                0 -> MyPageReviewFragment()
                1 -> MyPageWorkFragment()
                else -> throw Exception("존재하지 않는 탭입니다.")
            }
        }
    }

    fun setMenu(i : Int){
        menu = i
    }

}