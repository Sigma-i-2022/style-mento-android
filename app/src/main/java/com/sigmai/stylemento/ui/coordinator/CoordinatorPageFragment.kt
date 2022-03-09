package com.sigmai.stylemento.ui.coordinator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentCoordinatorPageBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.coordinator.adapter.CoordinatorPageViewPagerAdapter
import com.sigmai.stylemento.ui.home.adapter.TagAdapter

class CoordinatorPageFragment :
    BaseFragment<FragmentCoordinatorPageBinding>() {
    override val layoutResourceId = R.layout.fragment_coordinator_page
    private val viewModel: CoordinatorPageViewModel by activityViewModels()
    private var introductionState = 0

    private var position: Int = 0
    override fun initState() {
        super.initState()
        position = arguments?.getInt("position")!!
        viewModel.getCoordinatorInfo(position)
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.extendingIntroductionEvent.observe(this) {
            if (introductionState == 0) {
                binding.coordinatorPageIntroductionText.maxLines = 10
                introductionState = 1
            } else {
                binding.coordinatorPageIntroductionText.maxLines = 3
                introductionState = 0
            }
        }
        viewModel.startBack.observe(this) {
            findNavController().navigateUp()
        }
        viewModel.startReserve.observe(this) {
            findNavController().navigate(
                R.id.action_coordinator_page_to_reservation_time_page,
                arguments
            )
        }
        recyclerView()
    }

    private fun recyclerView() {
        binding.coordinatorPageViewPager.isUserInputEnabled = false
        binding.coordinatorPageViewPager.adapter = CoordinatorPageViewPagerAdapter(this)
        binding.coordinatorPageTagRecycler.adapter = TagAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this).load(viewModel.coordinator.value?.imageUrl)
            .into(binding.coordinatorPageImg)
    }
}