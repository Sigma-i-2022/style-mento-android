package com.sigmai.stylemento.ui.mypage.coordinator

import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentCoordinatorPageBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.home.adapter.TagAdapter
import dagger.hilt.android.AndroidEntryPoint
import com.sigmai.stylemento.ui.mypage.adapter.CoordinatorPageViewPagerAdapter
import android.view.View

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
        viewModel.isMyPage.value = isMyPage
        viewModel.email = arguments?.getString("email") ?: ""
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
            setOnSettingsListener {
                findNavController().navigate(R.id.action_coordinator_page_to_setting_page)
            }
        }
    }

    private fun setupObserver() {
        viewModel.startReserve.observe(this) {
            val bundle = bundleOf("Name" to viewModel.coordinator.value!!.userId, "Email" to viewModel.coordinator.value!!.email, "Url" to viewModel.coordinator.value!!.profileImgUrl)
            findNavController().navigate(
                R.id.action_coordinator_page_to_reservation_time_page,
                bundle
            )
        }
    }

    private fun setupRecyclerView() {
        with(binding.coordinatorPageViewPager) {
            adapter = CoordinatorPageViewPagerAdapter(this@CoordinatorPageFragment)
            isUserInputEnabled = false
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