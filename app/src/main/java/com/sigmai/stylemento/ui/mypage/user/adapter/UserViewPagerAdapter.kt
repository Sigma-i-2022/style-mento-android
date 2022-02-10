package com.sigmai.stylemento.ui.mypage.user.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sigmai.stylemento.ui.mypage.user.MyPageLookbookFragment

class UserViewPagerAdapter(f : Fragment) : FragmentStateAdapter(f){
    private var menu : Int = 0
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        /*return if (menu == 0) {
            when (position) {
                0 -> MyPageClosetFragment(owner)
                1 -> MyPageLookbookFragment(owner)
                else -> throw Exception("존재하지 않는 탭입니다.")
            }
        } else {
            when (position) {
                0 -> MyPageLookbookFragment(owner)
                1 -> MyPageClosetFragment(owner)
                else -> throw Exception("존재하지 않는 탭입니다.")
            }
        }*/
        return MyPageLookbookFragment()
    }
    fun setMenu(i : Int){
        menu = i
    }

}