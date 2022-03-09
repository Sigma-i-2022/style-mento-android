package com.sigmai.stylemento.ui.coordinator

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentCoordinatorPageBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.coordinator.adapter.CoordinatorPageViewPagerAdapter
import com.sigmai.stylemento.ui.home.adapter.TagAdapter

class CoordinatorPageFragment :
    BaseFragment<FragmentCoordinatorPageBinding>() {
    override val layoutResourceId = R.layout.fragment_coordinator_page
    private val viewModel: CoordinatorPageViewModel by activityViewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        setupRecyclerView()
        setupObserver()
    }

    override fun initState() {
        val position = arguments?.getInt("position")!!
        viewModel.getCoordinatorInfo(position)
    }

    private fun setupObserver() {
        viewModel.startBack.observe(this) {
            findNavController().navigateUp()
        }
        viewModel.startReserve.observe(this) {
            findNavController().navigate(
                R.id.action_coordinator_page_to_reservation_time_page,
                arguments
            )
        }
    }

    private fun setupRecyclerView() {
        binding.coordinatorPageViewPager.isUserInputEnabled = false
        binding.coordinatorPageViewPager.adapter = CoordinatorPageViewPagerAdapter(this)
        binding.coordinatorPageTagRecycler.adapter = TagAdapter()
    }
}