package com.sigmai.stylemento.ui.mypage.coordinator

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageCoordinatorRevisionBinding
import com.sigmai.stylemento.global.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageCoordinatorRevisionFragment : BaseFragment<FragmentMyPageCoordinatorRevisionBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_coordinator_revision
    private val viewModel: MyPageCoordinatorRevisionViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        setupButton()
    }

    override fun initState() {
        viewModel.loadData()
    }

    fun setupButton() {
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}