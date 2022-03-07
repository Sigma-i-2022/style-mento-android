package com.sigmai.stylemento.ui.coordinator_application

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ItemSnsInputBinding

class SnsAdapter : RecyclerView.Adapter<SnsAdapter.ViewHolder>() {
    companion object {
        const val FOCUSED_ITEM = 0
        const val UNFOCUSED_ITEM = 1
    }

    var list: List<String>? = null
        set(value) {
            field = value
            notifyItemRangeChanged(0, value!!.size)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list!![position])
    }

    override fun getItemCount() = list?.size ?: 0

    fun submitList(list: List<String>) {
        this.list = list
    }

    class ViewHolder(private val binding: ItemSnsInputBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemSnsInputBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

        fun bind(address: String) {
            binding.item = address
            binding.address.setOnFocusChangeListener { view, hasFocus ->
                if(hasFocus) view.setBackgroundResource(R.drawable.sns_background_type_2)
                else view.setBackgroundResource(R.drawable.sns_background_type_1)
            }
            binding.executePendingBindings()
        }
    }
}