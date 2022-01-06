package com.sigmai.stylemento.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.RecommendedCoordinator

class RecommendedCoordinatorAdapter(val recommendedList: List<RecommendedCoordinator>) : RecyclerView.Adapter<RecommendedCoordinatorAdapter.RecommendedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommeded_coordinator, parent, false)
        return RecommendedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendedViewHolder, position: Int) {
        holder.coordinatorName.text = recommendedList[position].name
        holder.tag.text = recommendedList[position].tag
    }

    override fun getItemCount() = recommendedList.size

    inner class RecommendedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val coordinatorName = view.findViewById<TextView>(R.id.recommended_coordinator_name)
        val tag = view.findViewById<TextView>(R.id.recommended_tag)
    }
}