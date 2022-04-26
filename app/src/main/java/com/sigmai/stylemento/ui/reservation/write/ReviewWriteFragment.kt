package com.sigmai.stylemento.ui.reservation.write

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.ReviewItem
import com.sigmai.stylemento.databinding.FragmentWriteReviewBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.constant.ReviewType

class ReviewWriteFragment : BaseFragment<FragmentWriteReviewBinding>() {
    override val layoutResourceId = R.layout.fragment_write_review
    private val viewModel : ReviewWriteViewModel by viewModels()

    private var reviewItem = ReviewItem(ReviewType.NORMAL, "")
    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this) {
            findNavController().navigateUp()
        }
        viewModel.startNext.observe(this) {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setRating(){

    }
}