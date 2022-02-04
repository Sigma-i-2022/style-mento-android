package com.sigmai.stylemento.feature

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.data.model.ReviewItem
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.databinding.FragmentWriteReviewBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.constant.ReviewType

class ReviewWriteFragment(private val writer : User, coordinator : Coordinator) : BaseFragment<FragmentWriteReviewBinding>() {
    override val layoutResourceId = R.layout.fragment_write_review

    private var reviewItem = ReviewItem(ReviewType.NORMAL, "")
    override fun initDataBinding() {
        super.initDataBinding()

        binding.writeReviewNameText.text = writer.nickname
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setEditText()
        setButton()
    }

    private fun setEditText(){
        binding.writeReviewHeightEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                reviewItem.height = p0.toString()
            }
        })
        binding.writeReviewWeightEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                reviewItem.weight = p0.toString()
            }
        })
        binding.writeReviewContentEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                reviewItem.content = p0.toString()
            }
        })
    }
    private fun setButton(){
        binding.writeReviewAllAgreeImg.setOnClickListener(View.OnClickListener {

        })
        binding.writeReviewFirstAgreeImg.setOnClickListener(View.OnClickListener {

        })
        binding.writeReviewSecondAgreeImg.setOnClickListener(View.OnClickListener {

        })

        binding.writeReviewCancelButton.setOnClickListener(View.OnClickListener {

        })
        binding.writeReviewSaveButton.setOnClickListener(View.OnClickListener {

        })
    }

    private fun setRating(){

    }
}