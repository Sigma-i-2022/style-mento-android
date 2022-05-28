package com.sigmai.stylemento.ui.mypage.add

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentAddPieceBinding
import com.sigmai.stylemento.databinding.StyleTagBottomSheetBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.MultipartUtil
import com.sigmai.stylemento.ui.home.adapter.TagAdapter
import com.sigmai.stylemento.ui.mypage.adapter.StyleTagSelectionAdapter
import com.sigmai.stylemento.ui.mypage.model.StyleTag
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddPieceFragment : BaseFragment<FragmentAddPieceBinding>() {
    override val layoutResourceId = R.layout.fragment_add_piece
    private val viewModel: AddPieceViewModel by viewModels()
    private var dialog: BottomSheetDialog? = null

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val multipartUtil = MultipartUtil()
        val image = multipartUtil.getMultipartBody(result, requireContext())
        image?.let {
            viewModel.uploadImage(image)
        }
    }

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
    }

    private fun setupObserver() {
        viewModel.onFinishEvent.observe(this) {
            findNavController().navigateUp()
        }
        viewModel.onImageEvent.observe(this) {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            launcher.launch(intent)
        }
        viewModel.tagSelectedEvent.observe(this) {
            dialog?.show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dialogBinding = StyleTagBottomSheetBinding.inflate(inflater, container, false)
        dialog = BottomSheetDialog(requireContext())
        dialog?.setContentView(dialogBinding.root)
        dialogBinding.items = listOf(
            StyleTag(tagName = "hoho2"),
            StyleTag(tagName = "hoho")
        )
        dialogBinding.tags.adapter = StyleTagSelectionAdapter()

        return super.onCreateView(inflater, container, savedInstanceState)
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
                viewModel.finish(it)
            }
        }
    }
}
