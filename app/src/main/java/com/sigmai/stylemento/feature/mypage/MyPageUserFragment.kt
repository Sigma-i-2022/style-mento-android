package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
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

        val interestedRecyclerView : RecyclerView = view.findViewById(R.id.user_interested_recycler)
        val interestedAdapter = UserInterestedAdapter(testDataSet)
        val linearLayoutManager = LinearLayoutManager(context)

        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        interestedRecyclerView.adapter = interestedAdapter
        interestedRecyclerView.layoutManager = linearLayoutManager

        val userViewPager : ViewPager2 = view.findViewById(R.id.user_viewPager)
        val userAdapter = UserViewPagerAdapter(this)
        userViewPager.adapter = userAdapter

        val closetButton : TextView = view.findViewById(R.id.my_page_closet_button)
        val lookbookButton : TextView = view.findViewById(R.id.my_page_lookbook_button)
        closetButton.setOnClickListener(View.OnClickListener {
            userViewPager.setCurrentItem(0, true)
            lookbookButton.setBackgroundResource(R.drawable.button_null)
            closetButton.setBackgroundResource(R.drawable.button_shadow)
        })
        lookbookButton.setOnClickListener(View.OnClickListener {
            userViewPager.setCurrentItem(1, true)
            lookbookButton.setBackgroundResource(R.drawable.button_shadow)
            closetButton.setBackgroundResource(R.drawable.button_null)
        })

        val revisionButton : ImageView = view.findViewById(R.id.user_revise_img)
        revisionButton.setOnClickListener(View.OnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.my_page_frameLayout, MyPageRevisionFragment())
            transaction.commit()
        })
    }
}