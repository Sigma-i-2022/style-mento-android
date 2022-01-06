package com.sigmai.stylemento.feature.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentHomeBinding
import com.sigmai.stylemento.feature.home.adapter.FavoriteCoordinatorAdapter
import com.sigmai.stylemento.global.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val layoutResourceId = R.layout.fragment_home
    private val viewModel: HomeViewModel by viewModels()

    override fun initState() {
        super.initState()
        getUserInfo()
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
    }

    fun getUserInfo() {
        viewModel.getUserInfo()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favoriteRecyclerView = view.findViewById<RecyclerView>(R.id.favorite_coordinator_list)
        favoriteRecyclerView.adapter = FavoriteCoordinatorAdapter(listOf("1", "2", "3", "1", "2", "3", "1", "2", "3"))
    }
}