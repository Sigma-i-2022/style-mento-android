package com.sigmai.stylemento.ui.mypage.user

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookScrollBinding
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.ui.mypage.user.adapter.UserLookbookItemAdapter
import com.sigmai.stylemento.ui.mypage.user.viewModel.MyPageLookbookScrollViewModel

class MyPageLookbookScrollFragment() : BaseFragment<FragmentMyPageLookbookScrollBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook_scroll
    private val viewModel: MyPageLookbookScrollViewModel by viewModels()

    override fun initState() {
        super.initState()
        viewModel.position.value = arguments?.getInt("position")!!
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel

        viewModel.startBack.observe(this, {
            findNavController().navigateUp()
        })

        binding.myPageUserLookbookScrollRecycler.adapter =
            UserLookbookItemAdapter(Client.getUserInfo().lookbookItems, viewModel)
        viewModel.position.observe(this) {
            binding.myPageUserLookbookScrollRecycler.scrollToPosition(viewModel.position.value!!)
        }
    }

    fun updateAdapterAfterDeleteLookbook(position: Int) {
        binding.myPageUserLookbookScrollRecycler.adapter!!.notifyDataSetChanged()
    }
}