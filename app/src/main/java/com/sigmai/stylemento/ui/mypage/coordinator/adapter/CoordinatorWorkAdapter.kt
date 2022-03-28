package com.sigmai.stylemento.ui.mypage.coordinator.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.WorkItem
import com.sigmai.stylemento.databinding.ItemCoordinatorWorkBinding


class CoordinatorWorkAdapter : RecyclerView.Adapter<CoordinatorWorkAdapter.ViewHolder>() {
    private var dataSet: List<WorkItem> = Client.getCoordinatorInfo().workItems

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int{
        return dataSet.size
    }

    fun setDataSet(items : List<WorkItem>){
        dataSet = items
    }

    class ViewHolder(val binding : ItemCoordinatorWorkBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : WorkItem){
            if (item.photoUrl == Uri.EMPTY)
                binding.coordinatorWorkItemImg.setImageResource(R.drawable.ic_launcher_foreground)
            else
                Glide.with(binding.coordinatorWorkItemImg).load(item.photoUrl)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.coordinatorWorkItemImg)
            binding.root.setOnClickListener(View.OnClickListener {
                val bundle = bundleOf("position" to adapterPosition)
                it.findNavController().navigate(R.id.action_main_to_work_scroll, bundle)
            })
        }

        companion object {
            fun from(parent: ViewGroup) : CoordinatorWorkAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCoordinatorWorkBinding.inflate(layoutInflater, parent, false)

                return CoordinatorWorkAdapter.ViewHolder(binding)
            }
        }
    }
}
