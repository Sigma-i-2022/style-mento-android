package com.sigmai.stylemento.ui.mypage

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.store.AuthenticationInfo
import com.sigmai.stylemento.ui.mypage.coordinator.CoordinatorPageFragment
import com.sigmai.stylemento.ui.mypage.client.MyPageClientFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment : BaseFragment<FragmentMyPageBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page
    private val viewModel: MyPageViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun initState() {
        setMyPageFragment()
    }

    private fun setMyPageFragment() {
        val transaction = when (AuthenticationInfo.userType) {
            AuthenticationInfo.TYPE_CLIENT ->
                childFragmentManager.beginTransaction()
                    .replace(R.id.my_page_frameLayout, MyPageClientFragment())
            AuthenticationInfo.TYPE_COORDINATOR ->
                childFragmentManager.beginTransaction()
                    .replace(R.id.my_page_frameLayout, CoordinatorPageFragment(true))
            else -> throw Exception("UNKNOWN USER TYPE")
        }

        transaction.addToBackStack(null)
        transaction.commit()
    }

}