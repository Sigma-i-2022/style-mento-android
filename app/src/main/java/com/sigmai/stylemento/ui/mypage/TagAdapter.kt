package com.sigmai.stylemento.ui.mypage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.global.constant.TagType
import com.sigmai.stylemento.global.util.TransformToStringUtil


class TagAdapter : RecyclerView.Adapter<TagAdapter.ViewHolder>() {

    private var dataSet: List<TagType> ?= null
    private val util : TransformToStringUtil = TransformToStringUtil()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tagText : TextView = view.findViewById(R.id.tag_text)
        init {

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_tag, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tagText.text = dataSet?.let { util.getTagString(it.get(position)) }
    }

    override fun getItemCount(): Int{
        if(dataSet != null)
            return dataSet!!.size
        return 0
    }

    fun setDataSet(items : List<TagType>?){
        dataSet = items
    }

}
