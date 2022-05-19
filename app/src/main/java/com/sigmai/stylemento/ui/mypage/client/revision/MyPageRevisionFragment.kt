package com.sigmai.stylemento.ui.mypage.client.revision

import android.app.Activity.RESULT_OK
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageRevisionBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.util.MultipartUtil
import com.sigmai.stylemento.global.util.PathUtil
import com.sigmai.stylemento.global.util.asRequestBody
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import timber.log.Timber
import java.io.File


@AndroidEntryPoint
class MyPageRevisionFragment : BaseFragment<FragmentMyPageRevisionBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_revision
    private val viewModel: MyPageRevisionViewModel by viewModels()

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

        binding.profilePhoto.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            launcher.launch(intent)
        }
    }

    override fun initState() {
        viewModel.getUserInfo()
    }

}