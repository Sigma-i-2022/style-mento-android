package com.sigmai.stylemento.ui.mypage.user.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.data.model.WorkItem
import com.sigmai.stylemento.ui.mypage.user.MyPageLookbookItemFragment
import com.sigmai.stylemento.databinding.ItemUserLookbookBinding
import com.sigmai.stylemento.domain.usecase.GetLookbookItemUseCase


class UserLookbookAdapter() : RecyclerView.Adapter<UserLookbookAdapter.ViewHolder>() {
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


    class ViewHolder(val binding: ItemUserLookbookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LookbookItem) {
            if (item.photoUrl == Uri.EMPTY)
                binding.userLookbookItemImg.setImageResource(R.drawable.ic_launcher_foreground)
            else
                Glide.with(binding.userLookbookItemImg).load(item.photoUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.userLookbookItemImg)
            binding.root.setOnClickListener(View.OnClickListener {
                val bundle = bundleOf("position" to adapterPosition)
                it.findNavController().navigate(R.id.action_main_to_lookbook_item, bundle)
            })
        }

        companion object {
            fun from(parent: ViewGroup): UserLookbookAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemUserLookbookBinding.inflate(layoutInflater, parent, false)

                return UserLookbookAdapter.ViewHolder(binding)
            }
        }
    }

}
