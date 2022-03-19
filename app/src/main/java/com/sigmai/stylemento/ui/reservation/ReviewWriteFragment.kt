package com.sigmai.stylemento.ui.reservation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.ReviewItem
import com.sigmai.stylemento.databinding.FragmentWriteReviewBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.constant.ReviewType
import com.sigmai.stylemento.ui.reservation.adapter.TimeAdapter
import com.sigmai.stylemento.ui.reservation.viewModel.ReviewWriteViewModel

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