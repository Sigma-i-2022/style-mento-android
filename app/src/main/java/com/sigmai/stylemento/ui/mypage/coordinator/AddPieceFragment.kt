package com.sigmai.stylemento.ui.mypage.coordinator

import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.WorkItem
import com.sigmai.stylemento.databinding.FragmentAddPieceBinding
import com.sigmai.stylemento.databinding.FragmentMyPageWorkAddBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.base.HavingImage
import com.sigmai.stylemento.global.base.HavingTag2
import com.sigmai.stylemento.ui.mypage.coordinator.viewModel.AddPieceViewModel
import timber.log.Timber

class AddPieceFragment : BaseFragment<FragmentAddPieceBinding>() {
    override val layoutResourceId = R.layout.fragment_add_piece
    private val viewModel: AddPieceViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun initState() {
        val pieceId = arguments?.getLong("id") ?: -1
        if(pieceId >= 0L) viewModel.loadPiece(pieceId)
        else Timber.e("Invalid piece id $pieceId")
    }
}
