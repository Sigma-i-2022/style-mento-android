package com.sigmai.stylemento.feature.mypage.coordinator.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.Coordinator
import com.sigmai.stylemento.data.model.WorkItem
import com.sigmai.stylemento.feature.mypage.coordinator.MyPageWorkItemFragment


class CoordinatorWorkAdapter(private val parantFragment : Fragment, private val owner : Coordinator) : RecyclerView.Adapter<CoordinatorWorkAdapter.ViewHolder>() {
    private var dataSet: List<WorkItem> = owner.workItems

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userWorkImg: ImageView = view.findViewById(R.id.coordinator_work_item_img)

        init {
            view.setOnClickListener(View.OnClickListener {
                val position: Int = adapterPosition
                val transaction = parantFragment.parentFragment?.parentFragmentManager?.beginTransaction()
                transaction?.replace(R.id.my_page_frameLayout, MyPageWorkItemFragment(owner, position))
                transaction?.commit()
            })
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_coordinator_work, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.userWorkImg.setImageResource(R.drawable.ic_launcher_foreground)
    }

    override fun getItemCount(): Int{
        return dataSet.size
    }

    fun setDataSet(items : List<WorkItem>){
        dataSet = items
    }

}
