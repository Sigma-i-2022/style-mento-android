package com.sigmai.stylemento.ui.coordinator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.repository.datasource.DummyCoordinatorDataSource
import com.sigmai.stylemento.databinding.FragmentCoordinatorPageBinding
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.coordinator.adapter.CoordinatorPageViewPagerAdapter
import com.sigmai.stylemento.ui.home.adapter.TagAdapter

class CoordinatorPageFragment :
    BaseFragment<FragmentCoordinatorPageBinding>() {
    override val layoutResourceId = R.layout.fragment_coordinator_page
    private val viewModel: CoordinatorPageViewModel by activityViewModels()
    private var introductionState = 0

    private var position: Int = 0
    private lateinit var coordinator: Coordinator
    override fun initState() {
        super.initState()
        position = arguments?.getInt("position")!!
        viewModel.getCoordinatorInfo(position)
        coordinator = Coordinator.from(DummyCoordinatorDataSource().getCoordinatorList()[position])
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startInstruction.observe(this) {
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
        viewModel.startChat.observe(this) {

        }
        viewModel.startReserve.observe(this) {
            findNavController().navigate(
                R.id.action_coordinator_page_to_reservation_time_page,
                arguments
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.coordinatorPageViewPager.isUserInputEnabled = false
        binding.coordinatorPageViewPager.adapter = CoordinatorPageViewPagerAdapter(this)

        val tagAdapter = TagAdapter()
        tagAdapter.setList(coordinator.tagList)
        binding.coordinatorPageTagRecycler.adapter = tagAdapter
        binding.coordinatorPageTagRecycler.visibility = View.GONE

        Glide.with(this).load(coordinator.imageUrl)
            .into(binding.coordinatorPageImg)
    }
}