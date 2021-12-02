package com.sigmai.stylemento.feature.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMainBinding
import com.sigmai.stylemento.global.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val layoutResourceId = R.layout.fragment_main

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = super.onCreateView(inflater, container, savedInstanceState)
//
//        val viewPager  = view?.findViewById<ViewPager2>(R.id.main_viewpager)
//        val pagerAdapter = MainPagerAdapter(this)
//        viewPager?.adapter = pagerAdapter
//
//        return view
//    }
}