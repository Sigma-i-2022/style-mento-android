package com.sigmai.stylemento.feature.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.RecommendedCoordinator
import com.sigmai.stylemento.databinding.FragmentHomeBinding
import com.sigmai.stylemento.feature.home.adapter.FavoriteCoordinatorAdapter
import com.sigmai.stylemento.feature.home.adapter.RecommendedCoordinatorAdapter
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

        viewModel.startNotification.observe(this, {
            findNavController().navigate(R.id.action_home_to_notification)
        })
    }

    fun getUserInfo() {
        viewModel.getUserInfo()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favoriteRecyclerView = view.findViewById<RecyclerView>(R.id.favorite_coordinator_list)
        favoriteRecyclerView.adapter = FavoriteCoordinatorAdapter()
        val recommendedRecyclerView = view.findViewById<RecyclerView>(R.id.recommended_coordinator_list)
        recommendedRecyclerView.adapter = RecommendedCoordinatorAdapter(viewModel)
    }
}