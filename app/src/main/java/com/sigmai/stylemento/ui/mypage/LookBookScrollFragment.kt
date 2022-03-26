package com.sigmai.stylemento.ui.mypage

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentLookBookScrollBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.mypage.adapter.PieceScrollAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class LookBookScrollFragment : BaseFragment<FragmentLookBookScrollBinding>() {
    override val layoutResourceId = R.layout.fragment_look_book_scroll
    val viewModel: LookBookScrollViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        binding.listview.adapter = PieceScrollAdapter()

        binding.toolbar.setOnBackListener {
            findNavController().navigateUp()
        }

        viewModel.scrollPosition.observe(this) {
            binding.listview.scrollToPosition(it)
        }
    }

    override fun initState() {
        val position = arguments?.getInt("position") ?: 0
        Timber.d("position $position")
        viewModel.loadData(position)
    }
}