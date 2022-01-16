package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageUserBinding
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageUserFragment : BaseFragment<FragmentMyPageUserBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_user
    private val viewModel: MyPageViewModel by viewModels()

    val testDataSet = arrayOf("1", "2", "3", "4", "5")

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val interestedAdapter = UserInterestedAdapter(testDataSet)
        val linearLayoutManager = LinearLayoutManager(context)

        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.myPageUserInterestedRecycler.adapter = interestedAdapter
        binding.myPageUserInterestedRecycler.layoutManager = linearLayoutManager

        val userAdapter = UserViewPagerAdapter(this)
        binding.myPageUserViewPager.adapter = userAdapter
        binding.myPageUserViewPager.isUserInputEnabled = false

        binding.myPageUserClosetButton.setOnClickListener(View.OnClickListener {
            binding.myPageUserViewPager.setCurrentItem(0, true)
            binding.myPageUserLookbookButton.setBackgroundResource(R.drawable.button_null)
            context?.let { it1 -> binding.myPageUserLookbookButton.setTextColor(it1.getColor(R.color.gray_d)) }
            binding.myPageUserClosetButton.setBackgroundResource(R.drawable.button_shadow)
            context?.let { it1 -> binding.myPageUserClosetButton.setTextColor(it1.getColor(R.color.black)) }
        })
        binding.myPageUserLookbookButton.setOnClickListener(View.OnClickListener {
            binding.myPageUserViewPager.setCurrentItem(1, true)
            binding.myPageUserLookbookButton.setBackgroundResource(R.drawable.button_shadow)
            context?.let { it1 -> binding.myPageUserLookbookButton.setTextColor(it1.getColor(R.color.black)) }
            binding.myPageUserClosetButton.setBackgroundResource(R.drawable.button_null)
            context?.let { it1 -> binding.myPageUserClosetButton.setTextColor(it1.getColor(R.color.gray_d)) }
        })

        binding.myPageUserReviseImg.setOnClickListener(View.OnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.my_page_frameLayout, MyPageRevisionFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        })
    }
}