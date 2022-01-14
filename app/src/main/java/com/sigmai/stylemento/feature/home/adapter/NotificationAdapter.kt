package com.sigmai.stylemento.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Notification
import com.sigmai.stylemento.databinding.ItemNotificationBinding

class NotificationAdapter(val notificationList: List<Notification>) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {
    var notifications: List<Notification>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.content.text = notificationList[position].content
    }

    override fun getItemCount() = notificationList.size

    fun setList(items: List<Notification>) {
        notifications = items
    }

    class NotificationViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val content = view.findViewById<TextView>(R.id.notification_content)

        companion object {
            fun from(parent: ViewGroup) : NotificationViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNotificationBinding.inflate(layoutInflater, parent, false)

                return NotificationViewHolder(binding.root)
            }
        }
    }
}