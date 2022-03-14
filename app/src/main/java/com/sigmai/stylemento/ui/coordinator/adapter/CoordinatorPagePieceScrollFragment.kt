package com.sigmai.stylemento.ui.coordinator.adapter

import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentCoordinatorPageWorkScrollBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.coordinator.coordinatorpage.CoordinatorPageViewModel

class CoordinatorPagePieceScrollFragment : BaseFragment<FragmentCoordinatorPageWorkScrollBinding>() {
    override val layoutResourceId = R.layout.fragment_coordinator_page_work_scroll
    private val viewModel: CoordinatorPageViewModel by activityViewModels()

    override fun initState() {
        setupRecyclerView()
        setupButton()
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.onEditEvent.observe(this) {
        val bundle = bundleOf("id" to 0L)
        val navController = findNavController()
        navController.navigate(R.id.action_coordinator_page_piece_scroll_to_add_piece, bundle)
        }
    }

    private fun setupButton() {
        binding.toolbar.setOnBackListener {
            findNavController().navigateUp()
        }
    }

    private fun setupRecyclerView() {
        val position = arguments?.getInt("position") ?: 0

        binding.coordinatorPageWorkScrollRecycler.adapter = CoordinatorPagePieceItemAdapter(viewModel)
        binding.coordinatorPageWorkScrollRecycler.scrollToPosition(position)
    }
}