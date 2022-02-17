package com.sigmai.stylemento.ui.mypage.coordinator.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.WorkItem
import com.sigmai.stylemento.databinding.ItemWorkScrollBinding
import com.sigmai.stylemento.ui.mypage.TagAdapter
import com.sigmai.stylemento.ui.mypage.coordinator.viewModel.MyPageWorkScrollViewModel


class CoordinatorWorkItemAdapter(
    private val dataSet: List<WorkItem>,
    private val viewModel: MyPageWorkScrollViewModel
) :
    RecyclerView.Adapter<CoordinatorWorkItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position], viewModel)
    }

    override fun getItemCount(): Int = dataSet.size


    class ViewHolder(val binding: ItemWorkScrollBinding) : RecyclerView.ViewHolder(binding.root) {
        private var detailState = 0
        fun bind(item: WorkItem, viewModel: MyPageWorkScrollViewModel) {
            binding.item = item

            setAdapter(item)
            setImage(item)
            setListener(viewModel)

            binding.executePendingBindings()
        }

        private fun setAdapter(item: WorkItem) {
            val workTagAdapter = TagAdapter()
            workTagAdapter.setDataSet(item.tags)
            binding.myPageCoordinatorWorkScrollTagRecycler.adapter = workTagAdapter
        }

        private fun setImage(item: WorkItem) {
            if (item.photoUrl == Uri.EMPTY)
                binding.myPageCoordinatorWorkScrollImg.setImageResource(R.drawable.ic_launcher_foreground)
            else
                Glide.with(binding.myPageCoordinatorWorkScrollImg).load(item.photoUrl)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.myPageCoordinatorWorkScrollImg)
        }

        private fun setListener(viewModel: MyPageWorkScrollViewModel) {

            binding.myPageCoordinatorWorkScrollRevision.setOnClickListener {
                viewModel.onClickRevision(it, adapterPosition)
            }

            binding.myPageCoordinatorWorkScrollDelete.setOnClickListener {
                viewModel.setDeleteDialog(it, adapterPosition)
            }

            binding.myPageCoordinatorWorkScrollDetail.setOnClickListener {
                if (detailState == 0) {
                    binding.myPageCoordinatorWorkScrollDetail.maxLines = 10
                    detailState = 1
                } else {
                    binding.myPageCoordinatorWorkScrollDetail.maxLines = 2
                    detailState = 0
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemWorkScrollBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

}
