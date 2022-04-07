package com.sigmai.stylemento.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.databinding.ItemReviewBinding
import com.sigmai.stylemento.domain.entity.Review
import com.sigmai.stylemento.ui.mypage.coordinator.MyPageReviewFragment

class CoordinatorReviewAdapter(private val f: MyPageReviewFragment) :
    RecyclerView.Adapter<CoordinatorReviewAdapter.ReviewViewHolder>() {
    private var reviewList: MutableList<Review> = mutableListOf(
        Review(rating = 4, nickname = "Keiee",content = "너무 좋아요~~", hasReply = false),
        Review(rating = 5, nickname = "iamgroot",content = "너무 좋아요~~", hasReply = true, reply = "이용해주셔서 감사합니다."),
        Review(rating = 3, nickname = "talking potato",content = "너무 좋아요~~", hasReply = false),
        Review(rating = 5, nickname = "gooooooogle",content = "너무 좋아요~~", hasReply = false),
    )
    val context: String = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return ReviewNormalViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val item = reviewList[position]
        holder.bind(item)
    }

    override fun getItemCount() = reviewList.size

    fun setList(items: MutableList<Review>) {
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
}