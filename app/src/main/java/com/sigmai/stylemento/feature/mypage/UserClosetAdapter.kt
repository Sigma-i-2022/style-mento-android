package com.sigmai.stylemento.feature.mypage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.ClosetItem


class UserClosetAdapter : RecyclerView.Adapter<UserClosetAdapter.ViewHolder>() {
    private var dataSet: List<ClosetItem> ?= null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userClosetImg: ImageView = view.findViewById(R.id.user_closet_item_img)

        init {
            // Define click listener for the ViewHolder's View.
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.user_closet_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.userClosetImg.setImageResource(R.drawable.ic_launcher_foreground)
    }

    override fun getItemCount(): Int{
        if(dataSet != null)
            return dataSet!!.size
        return 0
    }

    fun setDataSet(items : List<ClosetItem>?){
        dataSet = items
    }
}
