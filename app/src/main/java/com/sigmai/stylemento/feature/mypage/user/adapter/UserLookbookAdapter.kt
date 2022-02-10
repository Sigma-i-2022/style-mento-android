package com.sigmai.stylemento.feature.mypage.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.databinding.ItemPieceBinding
import com.sigmai.stylemento.feature.mypage.user.MyPageLookbookItemFragment
import com.sigmai.stylemento.databinding.ItemUserLookbookBinding
import com.sigmai.stylemento.feature.coordinator.adapter.HorizontalPieceAdapter


class UserLookbookAdapter(private val parentFragment : Fragment) : RecyclerView.Adapter<UserLookbookAdapter.ViewHolder>() {
    private var dataSet: List<LookbookItem> = Client.getUserInfo().lookbookItems

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(parentFragment)
    }

    override fun getItemCount(): Int{
        return dataSet.size
    }

    fun setDataSet(items : List<LookbookItem>){
        dataSet = items
    }


    class ViewHolder(val binding : ItemUserLookbookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(parentFragment : Fragment){
            binding.userLookbookItemImg.setImageResource(R.drawable.ic_launcher_foreground)
            binding.root.setOnClickListener(View.OnClickListener {
                val position: Int = adapterPosition
                val transaction = parentFragment.parentFragment?.parentFragmentManager?.beginTransaction()
                transaction?.replace(R.id.my_page_frameLayout, MyPageLookbookItemFragment(position))
                transaction?.commit()
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
