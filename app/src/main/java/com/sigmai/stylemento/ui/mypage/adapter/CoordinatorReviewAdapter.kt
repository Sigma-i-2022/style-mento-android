package com.sigmai.stylemento.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.databinding.ItemReviewBinding
import com.sigmai.stylemento.domain.entity.Review

class CoordinatorReviewAdapter :
    RecyclerView.Adapter<CoordinatorReviewAdapter.ReviewViewHolder>() {
    private var reviewList: List<Review> = listOf()
        set(items) {
            field = items
            notifyDataSetChanged()
        }
    val context: String = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return ReviewNormalViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val item = reviewList[position]
        holder.bind(item)
    }

    override fun getItemCount() = reviewList.size

    fun submitList(items: List<Review>) {
        reviewList = items
    }

    abstract class ReviewViewHolder protected constructor(val view: View) :
        RecyclerView.ViewHolder(view) {
        abstract fun bind(item: Review)
    }

    class ReviewNormalViewHolder(val binding: ItemReviewBinding) : ReviewViewHolder(binding.root) {
        private var reviewState = 0
        override fun bind(item: Review) {
            binding.item = item
            binding.reviewItemRating.rating = item.rating.toFloat()
            binding.reviewItemContentEditText.setOnClickListener {
                if (reviewState == 0) {
                    binding.reviewItemContentEditText.maxLines = 10
                    reviewState = 1
                } else {
                    binding.reviewItemContentEditText.maxLines = 2
                    reviewState = 0
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): ReviewViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemReviewBinding.inflate(layoutInflater, parent, false)

                return ReviewNormalViewHolder(binding)
            }
        }
    }
}