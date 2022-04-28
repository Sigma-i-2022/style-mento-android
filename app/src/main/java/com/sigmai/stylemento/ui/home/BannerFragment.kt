package com.sigmai.stylemento.ui.home

import androidx.fragment.app.activityViewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentBannerBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.main.MainViewModel

class BannerFragment(val img : Int = R.drawable.banner_client_1, val position : Int = 0) : BaseFragment<FragmentBannerBinding>() {
    override val layoutResourceId = R.layout.fragment_banner
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.bannerImage.setImageResource(img)

        if(position == 1){
            binding.bannerImage.setOnClickListener{
                mainViewModel.onFindCoordinator()
            }
        }
    }
}