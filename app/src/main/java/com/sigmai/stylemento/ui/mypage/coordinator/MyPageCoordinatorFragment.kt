package com.sigmai.stylemento.ui.mypage.coordinator

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.viewModels
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.ReviewItem
import com.sigmai.stylemento.databinding.FragmentMyPageCoordinatorBinding
import com.sigmai.stylemento.ui.mypage.TagAdapter
import com.sigmai.stylemento.ui.mypage.coordinator.adapter.CoordinatorViewPagerAdapter
import com.sigmai.stylemento.ui.mypage.coordinator.viewModel.MyPageCoordinatorViewModel
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.constant.ReviewType

class MyPageCoordinatorFragment(private var showMenu : Int) : BaseFragment<FragmentMyPageCoordinatorBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_coordinator
    private val viewModel: MyPageCoordinatorViewModel by viewModels()
    private var introductionState = 0

    override fun initState() {
        super.initState()
        viewModel.getCoordinatorInfo()
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startInstruction.observe(this, {
            if(introductionState == 0){
                binding.myPageCoordinatorIntroductionText.maxLines = 10
                introductionState = 1
            }
            else{
                binding.myPageCoordinatorIntroductionText.maxLines = 3
                introductionState = 0
            }
        })
        viewModel.startRevision.observe(this, {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.my_page_frameLayout, MyPageCoordinatorRevisionFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        })
        viewModel.startWork.observe(this, {
            showWork()
        })
        viewModel.startReview.observe(this, {
            showReview()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val coordinatorAdapter = CoordinatorViewPagerAdapter(this)
        binding.myPageCoordinatorViewPager.isUserInputEnabled = false
        if(showMenu == 0){
            coordinatorAdapter.setMenu(0)
            binding.myPageCoordinatorViewPager.adapter = coordinatorAdapter
            showWork()
        }
        else if(showMenu == 1) {
            coordinatorAdapter.setMenu(1)
            binding.myPageCoordinatorViewPager.adapter = coordinatorAdapter
            showReview()
        }

        val tagAdapter = TagAdapter()
        tagAdapter.setDataSet(Client.getCoordinatorInfo().styleTags)
        binding.myPageCoordinatorTagRecycler.adapter = tagAdapter

        binding.myPageCoordinatorButtonLayout.visibility = View.GONE
        binding.myPageCoordinatorReplyLayout.visibility = View.GONE
    }

    private fun showWork(){
        if(showMenu == 0)
            binding.myPageCoordinatorViewPager.setCurrentItem(0, true)
        else
            binding.myPageCoordinatorViewPager.setCurrentItem(1, true)

        binding.myPageCoordinatorReviewsButton.setBackgroundResource(R.drawable.button_null)
        context?.let { it1 -> binding.myPageCoordinatorReviewsButton.setTextColor(it1.getColor(R.color.gray_d)) }
        binding.myPageCoordinatorWorkButton.setBackgroundResource(R.drawable.button_shadow)
        context?.let { it1 -> binding.myPageCoordinatorWorkButton.setTextColor(it1.getColor(R.color.black)) }
    }
    private fun showReview(){
        if(showMenu == 1)
            binding.myPageCoordinatorViewPager.setCurrentItem(0, true)
        else
            binding.myPageCoordinatorViewPager.setCurrentItem(1, true)

        binding.myPageCoordinatorWorkButton.setBackgroundResource(R.drawable.button_null)
        context?.let { it1 -> binding.myPageCoordinatorWorkButton.setTextColor(it1.getColor(R.color.gray_d)) }
        binding.myPageCoordinatorReviewsButton.setBackgroundResource(R.drawable.button_shadow)
        context?.let { it1 -> binding.myPageCoordinatorReviewsButton.setTextColor(it1.getColor(R.color.black)) }
    }
    fun reply(position : Int){

        var content : String = ""
        binding.myPageCoordinatorReplyLayout.visibility = View.VISIBLE
        binding.myPageCoordinatorReplyTextEdit.setText("")
        binding.myPageCoordinatorReplyTextEdit.requestFocus()
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.showSoftInput(binding.myPageCoordinatorReplyTextEdit, 0)

        binding.myPageCoordinatorReplyTextEdit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                content = p0.toString()
            }
        })

        binding.myPageCoordinatorReplySendText.setOnClickListener(View.OnClickListener {
            Client.addReviewItemAt(ReviewItem(ReviewType.REPLY, Client.getCoordinatorInfo().nickname, content), position)
            binding.myPageCoordinatorReplyLayout.visibility = View.GONE
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(view?.windowToken, 0)

            val coordinatorAdapter = CoordinatorViewPagerAdapter(this)
            showMenu = 1
            coordinatorAdapter.setMenu(1)
            binding.myPageCoordinatorViewPager.adapter = coordinatorAdapter
            showReview()
        })
    }
}