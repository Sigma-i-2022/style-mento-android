package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageLookbookBinding
import com.sigmai.stylemento.feature.mypage.adapter.UserLookbookAdapter
import com.sigmai.stylemento.feature.mypage.dialog.UserLookbookAddDialog
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageLookbookFragment : BaseFragment<FragmentMyPageLookbookBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_lookbook

    val testDataSet = arrayOf("1", "2", "3", "4", "5")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lookbookAdapter = UserLookbookAdapter(testDataSet)
        val gridLayoutManager = GridLayoutManager(context,3, GridLayoutManager.VERTICAL, false)

        binding.myPageUserLookbookRecycler.adapter = lookbookAdapter
        binding.myPageUserLookbookRecycler.layoutManager = gridLayoutManager

        binding.myPageUserLookbookAddImg.setOnClickListener(View.OnClickListener {
            val dialog = UserLookbookAddDialog()
            dialog.show(childFragmentManager, "lookbookDialog")
        })
    }
}