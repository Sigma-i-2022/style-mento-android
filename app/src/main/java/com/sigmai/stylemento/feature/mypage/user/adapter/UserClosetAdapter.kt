package com.sigmai.stylemento.feature.mypage.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.ClosetItem
import com.sigmai.stylemento.feature.mypage.user.dialog.UserClosetItemDialog


class UserClosetAdapter(private val parentFragment : Fragment) : RecyclerView.Adapter<UserClosetAdapter.ViewHolder>() {
    private var dataSet: List<ClosetItem> ?= null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userClosetImg: ImageView = view.findViewById(R.id.user_closet_item_img)

        init {
            view.setOnClickListener(View.OnClickListener {
                val position: Int = adapterPosition
                dataSet?.let { it1 -> UserClosetItemDialog(parentFragment, it1.get(position).copy(), position) }
                    ?.show(parentFragment.childFragmentManager, "closetItemDialog")
            })
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_user_closet, viewGroup, false)

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
