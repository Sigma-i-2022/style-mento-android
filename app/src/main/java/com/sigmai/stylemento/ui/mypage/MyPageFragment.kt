package com.sigmai.stylemento.ui.mypage

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.store.AuthenticationInformation
import com.sigmai.stylemento.ui.coordinator.coordinatorpage.CoordinatorPageFragment
import com.sigmai.stylemento.ui.mypage.user.MyPageUserFragment
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
        val transaction = when (AuthenticationInformation.userType) {
            AuthenticationInformation.TYPE_CLIENT ->
                childFragmentManager.beginTransaction()
                    .replace(R.id.my_page_frameLayout, MyPageUserFragment())
            AuthenticationInformation.TYPE_COORDINATOR ->
                childFragmentManager.beginTransaction()
                    .replace(R.id.my_page_frameLayout, CoordinatorPageFragment(true))
            else -> throw Exception("UNKNOWN USER TYPE")
        }

        transaction.addToBackStack(null)
        transaction.commit()
    }

}