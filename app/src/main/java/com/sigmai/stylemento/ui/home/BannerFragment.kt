package com.sigmai.stylemento.ui.home

import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentBannerBinding
import com.sigmai.stylemento.global.base.BaseFragment

class BannerFragment(val img : Int, val action : Int) : BaseFragment<FragmentBannerBinding>() {
    override val layoutResourceId = R.layout.fragment_banner

    override fun initDataBinding() {
        super.initDataBinding()
        binding.bannerImage.setImageResource(img)
        binding.bannerImage.setOnClickListener(){
            findNavController().navigate(action)
        }
    }
}