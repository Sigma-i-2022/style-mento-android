package com.sigmai.stylemento.ui.mypage.user.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.data.model.WorkItem
import com.sigmai.stylemento.databinding.ItemLookbookScrollBinding
import com.sigmai.stylemento.ui.mypage.user.MyPageLookbookItemFragment
import com.sigmai.stylemento.databinding.ItemUserLookbookBinding
import com.sigmai.stylemento.domain.usecase.GetLookbookItemUseCase
import com.sigmai.stylemento.ui.mypage.TagAdapter


class UserLookbookItemAdapter : RecyclerView.Adapter<UserLookbookItemAdapter.ViewHolder>() {
    private var dataSet: List<LookbookItem> = Client.getUserInfo().lookbookItems

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun setDataSet(items: List<LookbookItem>) {
        dataSet = items
    }


    class ViewHolder(val binding: ItemLookbookScrollBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LookbookItem) {
            if (item.photoUrl == Uri.EMPTY)
                binding.myPageUserLookbookScrollImg.setImageResource(R.drawable.ic_launcher_foreground)
            else
                Glide.with(binding.myPageUserLookbookScrollImg).load(item.photoUrl)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.myPageUserLookbookScrollImg)

            binding.myPageUserLookbookScrollDetail.text = item.detail
            binding.myPageLookbookScrollTimeText.text = item.time
            binding.myPageLookbookScrollTopText.text = item.top
            binding.myPageLookbookScrollPantsText.text = item.pants
            binding.myPageLookbookScrollShoesText.text = item.shoes

            val lookbookTagAdapter = TagAdapter()
            lookbookTagAdapter.setDataSet(item.tags)
            binding.myPageUserLookbookScrollTagRecycler.adapter = lookbookTagAdapter

            binding.myPageUserLookbookScrollRevision.setOnClickListener(View.OnClickListener {
                val bundle = bundleOf("position" to adapterPosition)
                it.findNavController().navigate(R.id.action_lookbook_scroll_to_lookbook_add, bundle)
            })

            binding.myPageUserLookbookScrollDelete.setOnClickListener(View.OnClickListener {
                setDeleteDialog(it, adapterPosition)
            })
        }

        private fun setDeleteDialog(it : View, position: Int) {
            var builder = AlertDialog.Builder(it.context)
            builder.setMessage("이 아이템을 삭제 하시겠습니까?")

            var listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            Client.removeLookbookItem(position)
                            it.findNavController().navigateUp()
                        }
                    }
                }
            }

            builder.setPositiveButton("삭제", listener)
            builder.setNegativeButton("취소", listener)

            builder.show()
        }
        companion object {
            fun from(parent: ViewGroup): UserLookbookItemAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemLookbookScrollBinding.inflate(layoutInflater, parent, false)

                return UserLookbookItemAdapter.ViewHolder(binding)
            }
        }
    }

}
