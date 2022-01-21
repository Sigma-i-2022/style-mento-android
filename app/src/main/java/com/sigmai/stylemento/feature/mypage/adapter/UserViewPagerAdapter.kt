package com.sigmai.stylemento.feature.mypage.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.feature.mypage.MyPageClosetFragment
import com.sigmai.stylemento.feature.mypage.MyPageLookbookFragment
import java.lang.Exception

class UserViewPagerAdapter(f : Fragment, item : Fragment) : FragmentStateAdapter(f){
    private var fragment = item
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> fragment!!
            else -> throw Exception("존재하지 않는 탭입니다.")
        }
    }

    fun setFragment(position : Int){
        when(position){
            0 -> fragment = MyPageClosetFragment()
            1 -> fragment = MyPageLookbookFragment()
            else -> throw Exception("position error")
        }
    }

}