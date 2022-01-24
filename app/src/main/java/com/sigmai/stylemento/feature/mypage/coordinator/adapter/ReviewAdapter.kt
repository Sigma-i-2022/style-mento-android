package com.sigmai.stylemento.feature.mypage.coordinator.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.ReviewItem
import com.sigmai.stylemento.databinding.ItemReviewBinding
import com.sigmai.stylemento.databinding.ItemReviewReplyBinding
import com.sigmai.stylemento.global.constant.ReviewType
import java.lang.IllegalArgumentException

class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {
    var reviewList: MutableList<ReviewItem>? = mutableListOf()
    val context : String = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return when(viewType) {
            ReviewType.NORMAL -> ReviewNormalViewHolder.from(parent)
            ReviewType.REPLY -> ReviewReplyViewHolder.from(parent)
            else -> throw IllegalArgumentException("UNKNOWN VIEW TYPE")
        }
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val item = reviewList!![position]

        if(holder is ReviewNormalViewHolder){
            holder.bind(item)
            holder.view.setOnClickListener(View.OnClickListener {
                val item = ReviewItem(ReviewType.REPLY, "coordi1", "")
                Client.addReviewItemAt(item, position + 1)
                reviewList!!.add(position + 1, item)
            })
        }
        else if(holder is ReviewReplyViewHolder){
            holder.bind(item)

            var content : String = ""
            holder.view.setOnClickListener(View.OnClickListener {
                holder.replyEditText.addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(p0: Editable?) {
                        if (p0.toString() == ""){
                            Client.removeReviewItem(position)
                            reviewList!!.removeAt(position)
                        }
                        else{
                            val item = ReviewItem(ReviewType.REPLY, "coordi1", "", 0, p0.toString())
                            Client.reviseReviewItem(item, position)
                            reviseList(item, position)
                        }
                    }

                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        content = p0.toString()
                    }
                })
            })
        }
    }

    override fun getItemCount() = reviewList!!.size

    override fun getItemViewType(position: Int): Int {
        return reviewList!![position].type
    }

    fun setList(items: MutableList<ReviewItem>) {
        reviewList = items
    }
    fun reviseList(item: ReviewItem, position : Int) {
        reviewList?.removeAt(position)
        reviewList?.add(position, item)
    }

    abstract class ReviewViewHolder protected constructor(val view: View) : RecyclerView.ViewHolder(view)

    class ReviewNormalViewHolder(val binding: ItemReviewBinding) : ReviewViewHolder(binding.root) {
        fun bind(item: ReviewItem) {
            binding.item = item
            binding.reviewItemRating.rating = item.star.toFloat()
        }
        companion object {
            fun from(parent: ViewGroup) : ReviewViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemReviewBinding.inflate(layoutInflater, parent, false)

                return ReviewNormalViewHolder(binding)
            }
        }
    }

    class ReviewReplyViewHolder(val binding: ItemReviewReplyBinding) : ReviewViewHolder(binding.root) {
        val replyEditText = view.findViewById<EditText>(R.id.review_item_reply_content_editText)
        fun bind(item: ReviewItem) {
            binding.item = item
        }

        companion object {
            fun from(parent: ViewGroup) : ReviewViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemReviewReplyBinding.inflate(layoutInflater, parent, false)

                return ReviewReplyViewHolder(binding)
            }
        }
    }
}