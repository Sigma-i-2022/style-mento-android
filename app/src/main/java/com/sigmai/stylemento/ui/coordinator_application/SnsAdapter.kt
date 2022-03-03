package com.sigmai.stylemento.ui.coordinator_application

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.databinding.ItemSnsInputBinding

class SnsAdapter : RecyclerView.Adapter<SnsAdapter.ViewHolder>() {
    var list: List<String>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list!![position])
    }

    override fun getItemCount() = list?.size ?: 0

    class ViewHolder(private val binding: ItemSnsInputBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemSnsInputBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

        fun bind(address: String) {
//            binding.address.text = address
        }
    }
}