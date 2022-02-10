package com.sigmai.stylemento.ui.mypage.coordinator.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.ReviewItem
import com.sigmai.stylemento.databinding.ItemReviewBinding
import com.sigmai.stylemento.databinding.ItemReviewReplyBinding
import com.sigmai.stylemento.ui.mypage.coordinator.MyPageCoordinatorFragment
import com.sigmai.stylemento.ui.mypage.coordinator.MyPageReviewFragment
import com.sigmai.stylemento.global.constant.ReviewType
import java.lang.IllegalArgumentException

class CoordinatorReviewAdapter(private val f: MyPageReviewFragment) :
    RecyclerView.Adapter<CoordinatorReviewAdapter.ReviewViewHolder>() {
    var reviewList: MutableList<ReviewItem> = Client.getCoordinatorInfo().reviews
    val context: String = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return when (viewType) {
            ReviewType.NORMAL -> ReviewNormalViewHolder.from(parent)
            ReviewType.REPLY -> ReviewReplyViewHolder.from(parent)
            else -> throw IllegalArgumentException("UNKNOWN VIEW TYPE")
        }
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val item = reviewList[position]

        if (holder is ReviewNormalViewHolder) {
            holder.bind(item)
            holder.view.setOnClickListener(View.OnClickListener {
                val nextItem = Client.getReviewItemAt(position + 1)
                if (nextItem == null || nextItem.type == ReviewType.NORMAL) {
                    if (f.parentFragment is MyPageCoordinatorFragment) { (f.parentFragment as MyPageCoordinatorFragment).reply(position + 1)
                    }
                }
            })
        } else if (holder is ReviewReplyViewHolder) {
            holder.bind(item)
        }
    }

    override fun getItemCount() = reviewList.size

    override fun getItemViewType(position: Int): Int {
        return reviewList[position].type
    }

    fun setList(items: MutableList<ReviewItem>) {
        reviewList = items
    }

    abstract class ReviewViewHolder protected constructor(val view: View) :
        RecyclerView.ViewHolder(view)

    class ReviewNormalViewHolder(val binding: ItemReviewBinding) : ReviewViewHolder(binding.root) {
        private var reviewState = 0
        fun bind(item: ReviewItem) {
            binding.item = item
            binding.reviewItemRating.rating = item.star.toFloat()
            binding.reviewItemContentEditText.setOnClickListener(View.OnClickListener {
                if (reviewState == 0) {
                    binding.reviewItemContentEditText.maxLines = 10
                    reviewState = 1
                } else {
                    binding.reviewItemContentEditText.maxLines = 2
                    reviewState = 0
                }
            })

        }

        companion object {
            fun from(parent: ViewGroup): ReviewViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemReviewBinding.inflate(layoutInflater, parent, false)

                return ReviewNormalViewHolder(binding)
            }
        }
    }

    class ReviewReplyViewHolder(val binding: ItemReviewReplyBinding) : ReviewViewHolder(binding.root) {
        private var replyState = 0
        fun bind(item: ReviewItem) {
            binding.item = item
            binding.reviewItemReplyContentEditText.setOnClickListener(View.OnClickListener {
                if (replyState == 0) {
                    binding.reviewItemReplyContentEditText.maxLines = 10
                    replyState = 1
                } else {
                    binding.reviewItemReplyContentEditText.maxLines = 2
                    replyState = 0
                }
            })
        }

        companion object {
            fun from(parent: ViewGroup): ReviewViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemReviewReplyBinding.inflate(layoutInflater, parent, false)

                return ReviewReplyViewHolder(binding)
            }
        }
    }
}