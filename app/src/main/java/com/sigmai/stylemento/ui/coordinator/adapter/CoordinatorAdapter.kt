package com.sigmai.stylemento.ui.coordinator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.databinding.ItemCoordinatorBinding
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.ui.coordinator.CoordinatorViewModel
import com.sigmai.stylemento.ui.home.adapter.TagAdapter

class CoordinatorAdapter(val viewModel: CoordinatorViewModel) :
    ListAdapter<Coordinator, CoordinatorAdapter.CoordinatorViewHolder>(CoordinatorDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoordinatorViewHolder {
        return CoordinatorViewHolder.from(parent, viewModel)
    }

    override fun onBindViewHolder(holder: CoordinatorViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class CoordinatorViewHolder private constructor(
        val binding: ItemCoordinatorBinding,
        val viewModel: CoordinatorViewModel
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Coordinator) {
            binding.item = item
            binding.coordinatorTags.adapter = TagAdapter()
            binding.pieceList.adapter = HorizontalPieceAdapter()

            binding.root.setOnClickListener {
                viewModel.onClickCoordinatorProfile(it, item.email!!)
            }

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup, viewModel: CoordinatorViewModel): CoordinatorViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCoordinatorBinding.inflate(layoutInflater, parent, false)

                return CoordinatorViewHolder(binding, viewModel)
            }
        }
    }
}

class CoordinatorDiffCallback : DiffUtil.ItemCallback<Coordinator>() {
    override fun areItemsTheSame(oldItem: Coordinator, newItem: Coordinator): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Coordinator, newItem: Coordinator): Boolean {
        return oldItem == newItem
    }
}