package com.sigmai.stylemento.ui.coordinator.adapter

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.databinding.FragmentCoordinatorPageWorkScrollBinding
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookScrollBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.coordinator.CoordinatorPageViewModel
import com.sigmai.stylemento.ui.mypage.user.adapter.UserLookbookItemAdapter
import com.sigmai.stylemento.ui.mypage.user.viewModel.MyPageLookbookScrollViewModel

class CoordinatorPagePieceScrollFragment : BaseFragment<FragmentCoordinatorPageWorkScrollBinding>() {
    override val layoutResourceId = R.layout.fragment_coordinator_page_work_scroll
    private val viewModel: CoordinatorPageViewModel by activityViewModels()

    private var position: Int = 0
    override fun initState() {
        super.initState()
        position = arguments?.getInt("position")!!
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigateUp()
        }

        binding.coordinatorPageWorkScrollRecycler.adapter = CoordinatorPagePieceItemAdapter()
        binding.coordinatorPageWorkScrollRecycler.scrollToPosition(position)
//        viewModel.position.observe(this) {
//            binding.coordinatorPageWorkScrollRecycler.adapter =
//                CoordinatorPagePieceItemAdapter()
//            binding.coordinatorPageWorkScrollRecycler.scrollToPosition(viewModel.position.value!!)
//        }
    }
}