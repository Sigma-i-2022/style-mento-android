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
import com.sigmai.stylemento.feature.mypage.coordinator.MyPageCoordinatorFragment
import com.sigmai.stylemento.feature.mypage.coordinator.MyPageReviewFragment
import com.sigmai.stylemento.global.constant.ReviewType
import java.lang.IllegalArgumentException

class ReviewAdapter(private val f : MyPageReviewFragment) : RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {
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
                val item = Client.getReviewItemAt(position + 1)
                if(item == null || item.type == ReviewType.NORMAL){
                    if(f.parentFragment is MyPageCoordinatorFragment){
                        (f.parentFragment as MyPageCoordinatorFragment).reply(position + 1)
                    }
                }
            })
        }
        else if(holder is ReviewReplyViewHolder){
            holder.bind(item)
            f.updateAdapter()
        }
    }

    override fun getItemCount() = reviewList!!.size

    override fun getItemViewType(position: Int): Int {
        return reviewList!![position].type
    }

    fun setList(items: MutableList<ReviewItem>) {
        reviewList = items
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