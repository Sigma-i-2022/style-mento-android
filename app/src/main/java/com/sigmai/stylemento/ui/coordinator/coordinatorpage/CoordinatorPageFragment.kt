package com.sigmai.stylemento.ui.coordinator.coordinatorpage

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentCoordinatorPageBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.coordinator.adapter.CoordinatorPageViewPagerAdapter
import com.sigmai.stylemento.ui.home.adapter.TagAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoordinatorPageFragment(private val isMyPage: Boolean = false) :
    BaseFragment<FragmentCoordinatorPageBinding>() {
    override val layoutResourceId = R.layout.fragment_coordinator_page
    private val viewModel: CoordinatorPageViewModel by activityViewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        setupRecyclerView()
        setupObserver()
        setupButton()
    }

    override fun initState() {
        val position = arguments?.getInt("position") ?: 0
        viewModel.loadCoordinatorInfo(position)
        viewModel.isMyPage.value = isMyPage
        viewModel.loadData()
    }

    private fun setupButton() {
        with(binding.toolbar) {
            setOnBackListener {
                findNavController().navigateUp()
            }
            setOnEditListener {
                findNavController().navigate(R.id.action_main_to_coordinator_revision)
            }
        }
    }

    private fun setupObserver() {
        viewModel.startReserve.observe(this) {
            findNavController().navigate(
                R.id.action_coordinator_page_to_reservation_time_page,
                arguments
            )
        }
    }

    private fun setupRecyclerView() {
        binding.coordinatorPageViewPager.apply {
            isUserInputEnabled = false
            adapter = CoordinatorPageViewPagerAdapter(this@CoordinatorPageFragment)
            binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val position = tab!!.position
                    currentItem = position
                    if(viewModel.isMyPage.value!!) {
                        if(position == 1) binding.addPiece.visibility = View.INVISIBLE
                        else binding.addPiece.visibility = View.VISIBLE
                    }
                }
                override fun onTabUnselected(tab: TabLayout.Tab?) {}
                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })
        }

        binding.coordinatorPageTagRecycler.adapter = TagAdapter()
    }
}