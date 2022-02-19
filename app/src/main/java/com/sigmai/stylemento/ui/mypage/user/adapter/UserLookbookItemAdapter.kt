package com.sigmai.stylemento.ui.mypage.user.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.databinding.ItemLookbookScrollBinding
import com.sigmai.stylemento.ui.mypage.TagAdapter
import com.sigmai.stylemento.ui.mypage.user.viewModel.MyPageLookbookScrollViewModel

class UserLookbookItemAdapter(
    private val viewModel: MyPageLookbookScrollViewModel
) : ListAdapter<LookbookItem, UserLookbookItemAdapter.ViewHolder>(LookBookItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder.from(parent)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), viewModel)
    }

    class ViewHolder(val binding: ItemLookbookScrollBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var detailState = 0
        fun bind(item: LookbookItem, viewModel: MyPageLookbookScrollViewModel) {
            binding.item = item
            setImage(item)
            setAdapter(item)
            setListener(viewModel)

            binding.executePendingBindings()
        }

        private fun setAdapter(item: LookbookItem) {
            val lookbookTagAdapter = TagAdapter()
            lookbookTagAdapter.setDataSet(item.tags)
            binding.myPageUserLookbookScrollTagRecycler.adapter = lookbookTagAdapter
        }

        private fun setImage(item: LookbookItem) {
            if (item.photoUrl == Uri.EMPTY)
                binding.myPageUserLookbookScrollImg.setImageResource(R.drawable.ic_launcher_foreground)
            else
                Glide.with(binding.myPageUserLookbookScrollImg).load(item.photoUrl)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.myPageUserLookbookScrollImg)
        }

        private fun setListener(viewModel: MyPageLookbookScrollViewModel) {
            binding.myPageUserLookbookScrollRevision.setOnClickListener {
                viewModel.onClickRevision(it, adapterPosition)
            }

            binding.myPageUserLookbookScrollDelete.setOnClickListener {
                viewModel.setDeleteDialog(it, adapterPosition)
            }

            binding.myPageUserLookbookScrollDetail.setOnClickListener {
                if (detailState == 0) {
                    binding.myPageUserLookbookScrollDetail.maxLines = 10
                    detailState = 1
                } else {
                    binding.myPageUserLookbookScrollDetail.maxLines = 2
                    detailState = 0
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemLookbookScrollBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

// TODO : 임시 구현으로 나중에 id 값 비교 등으로 수정해야 함.
class LookBookItemDiffCallback() : DiffUtil.ItemCallback<LookbookItem>() {
    override fun areItemsTheSame(oldItem: LookbookItem, newItem: LookbookItem): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: LookbookItem, newItem: LookbookItem): Boolean {
        return oldItem == newItem
    }
}