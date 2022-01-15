package com.sigmai.stylemento.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.RecommendedCoordinator
import com.sigmai.stylemento.databinding.ItemRecommededCoordinatorBinding
import com.sigmai.stylemento.feature.home.HomeViewModel

class RecommendedCoordinatorAdapter(private val viewModel: HomeViewModel) : RecyclerView.Adapter<RecommendedCoordinatorAdapter.RecommendedViewHolder>() {
    var recommendedList: List<RecommendedCoordinator>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedViewHolder {
        return RecommendedViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecommendedViewHolder, position: Int) {
        val item = recommendedList!![position]

        holder.bind(viewModel, item)
    }

    override fun getItemCount() = recommendedList?.size ?: 0

    fun setList(list: List<RecommendedCoordinator>) {
        recommendedList = list
    }

    class RecommendedViewHolder private constructor(val binding: ItemRecommededCoordinatorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: HomeViewModel, item: RecommendedCoordinator) {
            binding.viewModel = viewModel
            binding.coordinator = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): RecommendedViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemRecommededCoordinatorBinding.inflate(layoutInflater, parent, false)

                return RecommendedViewHolder(binding)
            }
        }
    }
}