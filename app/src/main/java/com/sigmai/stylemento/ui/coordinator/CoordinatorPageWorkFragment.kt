package com.sigmai.stylemento.ui.coordinator

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentCoordinatorPageWorkBinding
import com.sigmai.stylemento.databinding.FragmentMyPageWorkBinding
import com.sigmai.stylemento.ui.mypage.coordinator.adapter.CoordinatorWorkAdapter
import com.sigmai.stylemento.ui.mypage.coordinator.viewModel.MyPageWorkViewModel
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.coordinator.adapter.CoordinatorPageWorkAdapter

class CoordinatorPageWorkFragment : BaseFragment<FragmentCoordinatorPageWorkBinding>() {
    override val layoutResourceId = R.layout.fragment_coordinator_page_work
    private val viewModel: CoordinatorPageViewModel by activityViewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.coordinatorPageWorkRecycler.adapter = CoordinatorPageWorkAdapter()
    }
}