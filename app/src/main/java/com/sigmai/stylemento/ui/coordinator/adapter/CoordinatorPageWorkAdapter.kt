package com.sigmai.stylemento.ui.coordinator.adapter

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.data.model.WorkItem
import com.sigmai.stylemento.databinding.ItemCoordinatorWorkBinding
import com.sigmai.stylemento.databinding.ItemUserLookbookBinding
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.global.util.GlideUtil
import com.sigmai.stylemento.ui.mypage.coordinator.MyPageWorkItemFragment
import com.sigmai.stylemento.ui.mypage.user.adapter.UserLookbookAdapter
import com.sigmai.stylemento.ui.mypage.user.adapter.UserLookbookAdapter.ViewHolder.Companion.from


class CoordinatorPageWorkAdapter : RecyclerView.Adapter<CoordinatorPageWorkAdapter.ViewHolder>() {
    private val dataSet = mutableListOf<Piece>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int{
        return dataSet.size
    }

    fun setDataSet(items : List<Piece>?){
        if(items != null){
            dataSet.clear()
            dataSet.addAll(items)
        }
    }

    class ViewHolder(val binding : ItemCoordinatorWorkBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Piece){
            Glide.with(binding.coordinatorWorkItemImg).load(item.imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.coordinatorWorkItemImg)
            binding.root.setOnClickListener {
                val bundle = bundleOf("position" to adapterPosition)
                it.findNavController().navigate(R.id.action_coordinator_page_to_coordinator_page_piece_scroll, bundle)
            }
        }

        companion object {
            fun from(parent: ViewGroup) : CoordinatorPageWorkAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCoordinatorWorkBinding.inflate(layoutInflater, parent, false)

                return CoordinatorPageWorkAdapter.ViewHolder(binding)
            }
        }
    }
}
