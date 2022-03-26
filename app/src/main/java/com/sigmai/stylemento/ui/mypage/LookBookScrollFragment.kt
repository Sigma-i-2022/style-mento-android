package com.sigmai.stylemento.ui.mypage

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentLookBookScrollBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.mypage.adapter.PieceScrollAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LookBookScrollFragment : BaseFragment<FragmentLookBookScrollBinding>() {
    override val layoutResourceId = R.layout.fragment_look_book_scroll
    val viewModel: LookBookScrollViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        binding.listview.adapter = PieceScrollAdapter()
    }

    override fun initState() {
        viewModel.loadData()
    }
}