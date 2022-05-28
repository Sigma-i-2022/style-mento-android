package com.sigmai.stylemento.ui.mypage.adapter

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.databinding.ItemReviewBinding
import com.sigmai.stylemento.domain.entity.Review

class CoordinatorReviewAdapter(val isMyPage: Boolean = false) :
    RecyclerView.Adapter<CoordinatorReviewAdapter.ReviewViewHolder>() {
    private var reviewList: List<Review> = listOf()
        set(items) {
            field = items
            notifyDataSetChanged()
        }
    val context: String = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return ReviewNormalViewHolder.from(parent, isMyPage)
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

    class ReviewNormalViewHolder(val binding: ItemReviewBinding, val isMyPage: Boolean) : ReviewViewHolder(binding.root) {
        init {
            binding.delete.setOnClickListener {
                binding.item?.let { item ->
                    if(!item.hasReply) return@let

                    val builder = AlertDialog.Builder(binding.root.context)
                    builder.setMessage("답글을 삭제하시겠습니까?")
                        .setPositiveButton("삭제") { _, _ -> item.deleteEvent!!(item.replySeq!!) }
                        .setNegativeButton("취소") { _, _ -> }

                    builder.create().show()
                }
            }

            binding.register.setOnClickListener {
                binding.item?.let { item ->
                    if(item.hasReply) return@let

                    val content = binding.reply.text.toString()
                    item.postEvent!!(item.seq, content)
                }
            }

            binding.delete.visibility = if(isMyPage) View.VISIBLE else View.GONE
            binding.register.visibility = if(isMyPage) View.VISIBLE else View.GONE
            binding.reply.isEnabled = isMyPage
        }

        override fun bind(item: Review) {
            binding.item = item

            binding.reply.visibility = if(item.hasReply || isMyPage) View.VISIBLE else View.GONE

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup, isMyPage: Boolean): ReviewViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemReviewBinding.inflate(layoutInflater, parent, false)

                return ReviewNormalViewHolder(binding, isMyPage)
            }
        }
    }
}