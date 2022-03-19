package com.sigmai.stylemento.ui.signup

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SignupFragmentStateAdapter(f: Fragment) : FragmentStateAdapter(f) {
    companion object {
        const val NUMBER_OF_PAGES = 6
    }

    override fun getItemCount() = NUMBER_OF_PAGES

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> EmailFragment()
            1 -> AuthenticationCodeFragment()
            2 -> IdFragment()
            3 -> PasswordFragment()
            4 -> PasswordConfirmFragment()
            5 -> SignUpFinishFragment()
            else -> throw Exception("잘못된 프레그먼트 페이지입니다.")
        }
    }
}