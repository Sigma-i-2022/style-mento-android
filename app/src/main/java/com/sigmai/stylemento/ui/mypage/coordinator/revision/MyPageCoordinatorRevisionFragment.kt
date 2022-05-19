package com.sigmai.stylemento.ui.mypage.coordinator.revision

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageCoordinatorRevisionBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.MultipartUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageCoordinatorRevisionFragment : BaseFragment<FragmentMyPageCoordinatorRevisionBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_coordinator_revision
    private val viewModel: MyPageCoordinatorRevisionViewModel by viewModels()

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

        setupButton()
    }

    override fun initState() {
        viewModel.loadData()

        binding.profilePhoto.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            launcher.launch(intent)
        }
    }

    fun setupButton() {
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}