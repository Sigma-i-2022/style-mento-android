package com.sigmai.stylemento.ui.mypage.user.adapter

import android.app.AlertDialog
import android.content.DialogInterface
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.databinding.ItemLookbookScrollBinding
import com.sigmai.stylemento.ui.mypage.TagAdapter
import com.sigmai.stylemento.ui.mypage.user.MyPageLookbookScrollFragment

// todo : UserLookbookItemAdapter 를 사용하고 있는 곳은 이 Adapter 를 사용하도록 변경해야 함.
class UserLookbookItemAdapter2(private val parentFragment: MyPageLookbookScrollFragment, private val dataSet: List<LookbookItem>) :
    RecyclerView.Adapter<UserLookbookItemAdapter2.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder.from(parent)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position], parentFragment)
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(val binding: ItemLookbookScrollBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var detailState = 0
        fun bind(item: LookbookItem, parentFragment: MyPageLookbookScrollFragment) {
            binding.item = item
            if (item.photoUrl == Uri.EMPTY)
                binding.myPageUserLookbookScrollImg.setImageResource(R.drawable.ic_launcher_foreground)
            else
                Glide.with(binding.myPageUserLookbookScrollImg).load(item.photoUrl)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.myPageUserLookbookScrollImg)

            val lookbookTagAdapter = TagAdapter()
            lookbookTagAdapter.setDataSet(item.tags)
            binding.myPageUserLookbookScrollTagRecycler.adapter = lookbookTagAdapter

            binding.myPageUserLookbookScrollRevision.setOnClickListener(View.OnClickListener {
                val bundle = bundleOf("position" to adapterPosition)
                it.findNavController().navigate(R.id.action_lookbook_scroll_to_lookbook_add, bundle)
            })

            binding.myPageUserLookbookScrollDelete.setOnClickListener(View.OnClickListener {
                setDeleteDialog(it, adapterPosition, parentFragment)
            })
            setListener()

            binding.executePendingBindings()
        }

        private fun setDeleteDialog(
            it: View,
            position: Int,
            parentFragment: MyPageLookbookScrollFragment
        ) {
            val builder = AlertDialog.Builder(it.context)
            builder.setMessage("이 아이템을 삭제 하시겠습니까?")

            val listener = DialogInterface.OnClickListener { p0, p1 ->
                when (p1) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        Client.removeLookbookItem(position)
                        parentFragment.updateAdapter(position)
                    }
                }
            }

            builder.setPositiveButton("삭제", listener)
            builder.setNegativeButton("취소", listener)

            builder.show()
        }

        private fun setListener() {
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
