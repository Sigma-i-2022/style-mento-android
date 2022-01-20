package com.sigmai.stylemento.feature.mypage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.ClosetItem
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.feature.mypage.dialog.UserClosetItemDialog


class UserLookbookAdapter(private val parantFragment : Fragment) : RecyclerView.Adapter<UserLookbookAdapter.ViewHolder>() {

    private var dataSet: List<LookbookItem> ?= null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val revisionImg: ImageView = view.findViewById(R.id.user_lookbook_item_revision)
        val deleteImg : ImageView = view.findViewById(R.id.user_lookbook_item_delete)
        val itemImg : ImageView = view.findViewById(R.id.user_lookbook_item_img)
        val detailText : TextView = view.findViewById(R.id.user_lookbook_item_detail)
        val tagRecycler : RecyclerView = view.findViewById(R.id.user_lookbook_item_tag_recycler)
        val topText : TextView = view.findViewById(R.id.my_page_lookbook_item_top_text)
        val pantsText : TextView = view.findViewById(R.id.my_page_lookbook_item_pants_text)
        val shoesText : TextView = view.findViewById(R.id.my_page_lookbook_item_shoes_text)

        init {
            //소유자가 다른 경우 수정 삭제 이미지 숨기기 View.GONE

            revisionImg.setOnClickListener(View.OnClickListener {

            })
            deleteImg.setOnClickListener(View.OnClickListener {

            })
            if(dataSet?.size!! > 0){
                val lookbookTagAdapter = TagAdapter()
                lookbookTagAdapter.setDataSet(dataSet?.get(adapterPosition)?.tags)
                tagRecycler.adapter = lookbookTagAdapter
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.user_lookbook_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.itemImg.setImageResource(R.drawable.ic_launcher_foreground)
        viewHolder.detailText.text = dataSet?.get(position)?.deltail
        viewHolder.topText.text = dataSet?.get(position)?.top
        viewHolder.pantsText.text = dataSet?.get(position)?.pants
        viewHolder.shoesText.text = dataSet?.get(position)?.shoes
    }

    override fun getItemCount(): Int{
        if(dataSet != null)
            return dataSet!!.size
        return 0
    }

    fun setDataSet(items : List<LookbookItem>?){
        dataSet = items
    }

}
