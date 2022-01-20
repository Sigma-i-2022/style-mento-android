package com.sigmai.stylemento.feature.mypage.adapter

import android.app.AlertDialog
import android.content.DialogInterface
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
import com.sigmai.stylemento.feature.mypage.MyPageLookbookFragment
import com.sigmai.stylemento.feature.mypage.MyPageLookbookRevisionFragment
import com.sigmai.stylemento.feature.mypage.MyPageUserFragment
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
            val position = adapterPosition
            if(Client.getUserInfo().nickname != dataSet?.get(0)?.owner){
                revisionImg.visibility = View.GONE
                deleteImg.visibility = View.GONE
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

        val lookbookTagAdapter = TagAdapter()
        lookbookTagAdapter.setDataSet(dataSet?.get(position)?.tags)
        viewHolder.tagRecycler.adapter = lookbookTagAdapter

        viewHolder.revisionImg.setOnClickListener(View.OnClickListener {
            val transaction = parantFragment.parentFragmentManager.beginTransaction()
            transaction.replace(R.id.my_page_frameLayout, MyPageLookbookRevisionFragment(dataSet!!.get(position).copy(), position))
            transaction.commit()
        })

        viewHolder.deleteImg.setOnClickListener(View.OnClickListener {
            var builder = AlertDialog.Builder(parantFragment.context)
            builder.setMessage("이 아이템을 삭제 하시겠습니까?")

            var listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            Client.removeLookbookItem(position)
                            val transaction = parantFragment.parentFragmentManager.beginTransaction()
                            transaction.replace(R.id.my_page_frameLayout, MyPageLookbookFragment())
                            transaction.commit()
                        }
                    }
                }
            }

            builder.setPositiveButton("삭제", listener)
            builder.setNegativeButton("취소", listener)

            builder.show()
        })
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
