package com.sigmai.stylemento.feature.coordinator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.databinding.ItemCoordinatorBinding

class CoordinatorAdapter : RecyclerView.Adapter<CoordinatorAdapter.CoordinatorViewHolder>() {
    var coordinatorList: List<Coordinator>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoordinatorViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CoordinatorViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    fun setList(list: List<Coordinator>) {
        coordinatorList = list
    }

    class CoordinatorViewHolder private constructor(binding: ItemCoordinatorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Coordinator) {

        }

        companion object {
            fun from(parent: ViewGroup) : CoordinatorViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCoordinatorBinding.inflate(layoutInflater, parent, false)

                return CoordinatorViewHolder(binding)
            }
        }
    }
}