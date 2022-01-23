package com.sigmai.stylemento.feature.coordinator.adapter

import androidx.recyclerview.widget.DiffUtil

class DiffUntilCallback(
    private val oldData: List<Any>,
    private val newData: List<Any>
    ) : DiffUtil.Callback() {

    override fun getOldListSize() = oldData.size
    override fun getNewListSize() = newData.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldData[oldItemPosition] == newData[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldData[oldItemPosition] == newData[newItemPosition]
    }
}