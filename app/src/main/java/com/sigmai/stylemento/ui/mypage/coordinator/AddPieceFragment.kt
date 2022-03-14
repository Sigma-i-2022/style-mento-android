package com.sigmai.stylemento.ui.mypage.coordinator

import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentAddPieceBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.home.adapter.TagAdapter
import com.sigmai.stylemento.ui.mypage.coordinator.viewModel.AddPieceViewModel
import timber.log.Timber

class AddPieceFragment : BaseFragment<FragmentAddPieceBinding>() {
    override val layoutResourceId = R.layout.fragment_add_piece
    private val viewModel: AddPieceViewModel by viewModels()

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        setupRecyclerView()
        setupToolbar()
        setupObserver()
    }

    override fun initState() {
        val pieceId = arguments?.getLong("id") ?: -1
        if (pieceId >= 0L) viewModel.loadPiece(pieceId)
        else Timber.e("Invalid piece id $pieceId")
    }

    private fun setupObserver() {
        viewModel.onFinishEvent.observe(this) {
            findNavController().navigateUp()
        }
    }

    private fun setupRecyclerView() {
        binding.tagList.adapter = TagAdapter()
    }

    private fun setupToolbar() {
        binding.toolbar.apply {
            setOnBackListener {
                findNavController().navigateUp()
            }

            setOnFinishListener {
                viewModel.finish()
            }
        }
    }
}
