package com.sigmai.stylemento.ui.coordinator_application

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.databinding.ItemSnsCompletionBinding
import com.sigmai.stylemento.databinding.ItemSnsInputBinding

class SnsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val FOCUSED_ITEM = 0
        const val UNFOCUSED_ITEM = 1
    }

    private var focusedPosition = 0
    var list: List<String>? = null
        set(value) {
            field = value
            notifyItemRangeChanged(0, value!!.size)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        return if(viewType == FOCUSED_ITEM) FocusedItemViewHolder.from(parent)
            else UnfocusedItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == focusedPosition) (holder as FocusedItemViewHolder).bind(list!![position])
        else (holder as UnfocusedItemViewHolder).bind(list!![position])
    }

    override fun getItemCount() = list?.size ?: 0

    fun submitList(list: List<String>) {
        this.list = list
    }

    override fun getItemViewType(position: Int): Int {
        return if(position == focusedPosition) FOCUSED_ITEM else UNFOCUSED_ITEM
    }

    class FocusedItemViewHolder(private val binding: ItemSnsInputBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup) : FocusedItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemSnsInputBinding.inflate(layoutInflater, parent, false)

                return FocusedItemViewHolder(binding)
            }
        }

        fun bind(address: String) {
            binding.address.setText(address)
        }
    }

    class UnfocusedItemViewHolder(private val binding: ItemSnsCompletionBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup) : UnfocusedItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemSnsCompletionBinding.inflate(layoutInflater, parent, false)

                return UnfocusedItemViewHolder(binding)
            }
        }

        fun bind(address: String) {
            binding.address.setText(address)
        }
    }
}