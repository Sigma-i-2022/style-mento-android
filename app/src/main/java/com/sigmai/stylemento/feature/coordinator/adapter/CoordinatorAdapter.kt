package com.sigmai.stylemento.feature.coordinator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.databinding.ItemCoordinatorBinding

class CoordinatorAdapter : RecyclerView.Adapter<CoordinatorAdapter.CoordinatorViewHolder>() {
    var coordinatorList: List<Coordinator>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoordinatorViewHolder {
        return CoordinatorViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CoordinatorViewHolder, position: Int) {
        val item = coordinatorList!![position]
        holder.bind(item)
    }

    override fun getItemCount() = coordinatorList?.size ?: 0

    fun setList(list: List<Coordinator>) {
        coordinatorList = list
    }

    class CoordinatorViewHolder private constructor(val binding: ItemCoordinatorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Coordinator) {
            binding.item = item
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