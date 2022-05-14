package com.sigmai.stylemento.ui.main

import android.view.MenuItem
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMainBinding
import com.sigmai.stylemento.ui.main.adapter.MainPagerAdapter
import com.sigmai.stylemento.global.base.BaseFragment
import timber.log.Timber

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val layoutResourceId = R.layout.fragment_main
    private val viewModel: MainViewModel by activityViewModels()

    private val pages = listOf(R.id.page_home, R.id.page_coordinator, R.id.page_my)
    private val positions = mapOf(
        R.id.page_home to 0,
        R.id.page_coordinator to 1,
        R.id.page_my to 2)

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        setupObserver()
    }

    override fun initState() {
        super.initState()

        setBottomNavigation()
    }

    private fun setBottomNavigation() {
        binding.mainViewpager.apply {
            adapter = MainPagerAdapter(this@MainFragment)
            isUserInputEnabled = false
            registerOnPageChangeCallback(onPageChangeCallback)
        }

        binding.bottomNavigation.setOnItemSelectedListener { onItemSelected(it) }
    }

    private val onPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            binding.bottomNavigation.selectedItemId = pages[position]
        }
    }

    private fun onItemSelected(item: MenuItem) : Boolean {
        binding.mainViewpager.currentItem =
            positions[item.itemId]
                ?: throw Exception("알 수 없는 탭입니다.")

        return true
    }

    private fun setupObserver() {
        viewModel.onFindCoordinatorEvent.observe(this) {
            binding.mainViewpager.currentItem = 1
        }
        viewModel.onMyPageEvent.observe(this) {
            binding.mainViewpager.currentItem = 3
        }
    }
}