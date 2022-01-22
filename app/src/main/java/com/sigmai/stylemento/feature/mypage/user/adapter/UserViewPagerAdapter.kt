package com.sigmai.stylemento.feature.mypage.user.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.feature.mypage.user.MyPageClosetFragment
import com.sigmai.stylemento.feature.mypage.user.MyPageLookbookFragment
import java.lang.Exception

class UserViewPagerAdapter(f : Fragment) : FragmentStateAdapter(f){
    private var menu : Int = 0
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if(menu == 0){
            when(position) {
                0 -> MyPageClosetFragment()
                1 -> MyPageLookbookFragment()
                else -> throw Exception("존재하지 않는 탭입니다.")
            }
        } else{
            when(position) {
                0 -> MyPageLookbookFragment()
                1 -> MyPageClosetFragment()
                else -> throw Exception("존재하지 않는 탭입니다.")
            }
        }
    }

    /*fun setFragment(position : Int){
        when(position){
            0 -> fragment = MyPageClosetFragment()
            1 -> fragment = MyPageLookbookFragment()
            else -> throw Exception("position error")
        }
    }*/
    fun setMenu(i : Int){
        menu = i
    }

}