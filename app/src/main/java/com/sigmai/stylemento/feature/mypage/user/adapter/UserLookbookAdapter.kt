package com.sigmai.stylemento.feature.mypage.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.feature.mypage.user.MyPageLookbookItemFragment


class UserLookbookAdapter(private val parantFragment : Fragment) : RecyclerView.Adapter<UserLookbookAdapter.ViewHolder>() {
    private var dataSet: List<LookbookItem> = listOf()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userLookbookImg: ImageView = view.findViewById(R.id.user_lookbook_item_img)

        init {
            view.setOnClickListener(View.OnClickListener {
                val position: Int = adapterPosition
                val transaction = parantFragment.parentFragment?.parentFragmentManager?.beginTransaction()
                transaction?.replace(R.id.my_page_frameLayout, MyPageLookbookItemFragment(owner, position))
                transaction?.commit()
            })
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_user_lookbook, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.userLookbookImg.setImageResource(R.drawable.ic_launcher_foreground)
    }

    override fun getItemCount(): Int{
        return dataSet.size
    }

    fun setDataSet(items : List<LookbookItem>){
        dataSet = items
    }

}
