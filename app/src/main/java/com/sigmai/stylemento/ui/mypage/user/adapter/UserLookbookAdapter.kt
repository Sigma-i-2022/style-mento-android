package com.sigmai.stylemento.ui.mypage.user.adapter

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
import com.sigmai.stylemento.ui.mypage.user.MyPageLookbookItemFragment
import com.sigmai.stylemento.databinding.ItemUserLookbookBinding


class UserLookbookAdapter(private val parentFragment : Fragment) : RecyclerView.Adapter<UserLookbookAdapter.ViewHolder>() {
    private var dataSet: List<LookbookItem> = Client.getUserInfo().lookbookItems

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(parentFragment, dataSet[position])
    }

    override fun getItemCount(): Int{
        return dataSet.size
    }

    fun setDataSet(items : List<LookbookItem>){
        dataSet = items
    }


    class ViewHolder(val binding : ItemUserLookbookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(parentFragment : Fragment, item : LookbookItem){
            Glide.with(parentFragment).load(item.photoUrl).into(binding.userLookbookItemImg)
            binding.root.setOnClickListener(View.OnClickListener {
                val bundle = bundleOf("position" to adapterPosition)
                it.findNavController().navigate(R.id.action_main_to_lookbook_item, bundle)
            })
        }

        companion object {
            fun from(parent: ViewGroup) : UserLookbookAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemUserLookbookBinding.inflate(layoutInflater, parent, false)

                return UserLookbookAdapter.ViewHolder(binding)
            }
        }
    }

}
