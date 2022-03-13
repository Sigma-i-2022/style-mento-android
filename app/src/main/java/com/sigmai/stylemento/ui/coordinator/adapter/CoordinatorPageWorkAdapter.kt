package com.sigmai.stylemento.ui.coordinator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ItemCoordinatorWorkBinding
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.ui.coordinator.coordinatorpage.CoordinatorPageViewModel


class CoordinatorPageWorkAdapter(val viewModel: CoordinatorPageViewModel) : RecyclerView.Adapter<CoordinatorPageWorkAdapter.ViewHolder>() {
    private val dataSet = mutableListOf<Piece>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent, viewModel)
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

    class ViewHolder(val binding : ItemCoordinatorWorkBinding, val viewModel: CoordinatorPageViewModel) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Piece){
            Glide.with(binding.coordinatorWorkItemImg).load(item.imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.coordinatorWorkItemImg)
            binding.root.setOnClickListener {
                viewModel.onClickPiece(it, adapterPosition)
            }
        }

        companion object {
            fun from(parent: ViewGroup, viewModel: CoordinatorPageViewModel) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCoordinatorWorkBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding, viewModel)
            }
        }
    }
}
