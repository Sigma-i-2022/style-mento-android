package com.sigmai.stylemento.ui.home

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentHomeBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.home.adapter.BannerViewPagerAdapter
import com.sigmai.stylemento.ui.main.MainActivity
import com.sigmai.stylemento.ui.main.MainViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val layoutResourceId = R.layout.fragment_home
    private val viewModel: HomeViewModel by viewModels()
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun initState() {
        super.initState()
        getUserInfo()
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
        binding.mainViewModel = mainViewModel

        if(activity is MainActivity){
            (activity as MainActivity).checkPermission()
        }
        setBannerViewPager()
        setupObserver()
    }

    fun getUserInfo() {
        viewModel.getUserInfo()
    }
    private fun setBannerViewPager(){
        binding.banner.adapter = BannerViewPagerAdapter(this)
    }
    private fun setupObserver() {
        viewModel.startNotification.observe(this) {
            findNavController().navigate(R.id.action_main_to_notification)
        }
        viewModel.startCheckReservation.observe(this) {
            findNavController().navigate(R.id.action_main_to_reservation_user_list_page)
        }
        viewModel.startPrivacy.observe(this){
            val dialog = PrivacyDialogFragment()
            dialog.show(childFragmentManager, "privacy")
        }
    }
}