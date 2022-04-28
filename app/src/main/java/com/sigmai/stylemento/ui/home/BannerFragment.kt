package com.sigmai.stylemento.ui.home

import androidx.fragment.app.activityViewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentBannerBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.main.MainViewModel
import timber.log.Timber

class BannerFragment : BaseFragment<FragmentBannerBinding>() {
    override val layoutResourceId = R.layout.fragment_banner
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun initDataBinding() {
        super.initDataBinding()

        val resourceId: Int = arguments?.getInt("resourceId") ?: R.drawable.banner_client_1
        val position: Int = arguments?.getInt("position") ?: 0

        binding.bannerImage.setImageResource(resourceId)

        if(position == 1) {
            binding.bannerImage.setOnClickListener{
                mainViewModel.onFindCoordinator()
            }
        }
    }
}