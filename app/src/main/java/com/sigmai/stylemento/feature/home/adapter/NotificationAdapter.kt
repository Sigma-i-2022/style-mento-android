package com.sigmai.stylemento.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.Notification
import com.sigmai.stylemento.databinding.ItemNotificationBinding

class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {
    var notificationList: List<Notification>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val item = notificationList!![position]
        holder.bind(item)
    }

    override fun getItemCount() = notificationList?.size ?: 0

    fun setList(items: List<Notification>) {
        notificationList = items
    }

    class NotificationViewHolder private constructor(val binding: ItemNotificationBinding) : RecyclerView.ViewHolder(binding.root) {
        val content = binding.notificationContent

        fun bind(item: Notification) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : NotificationViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNotificationBinding.inflate(layoutInflater, parent, false)

                return NotificationViewHolder(binding)
            }
        }
    }
}