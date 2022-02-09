package com.sigmai.stylemento.feature.mypage.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ItemSampleTagBinding

class SampleTagAdapter(private val tagList: List<String>, var clickable: Boolean = true) : RecyclerView.Adapter<SampleTagAdapter.SampleTagViewHolder>() {
    val selectedTags: MutableList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleTagViewHolder = SampleTagViewHolder.from(parent)
    override fun onBindViewHolder(holder: SampleTagViewHolder, position: Int) {
        holder.bind(tagList[position], selectedTags, clickable)
    }
    override fun getItemCount() = tagList.size

    class SampleTagViewHolder private constructor(val binding: ItemSampleTagBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tagName: String, selectedTags: MutableList<String>, clickable: Boolean) {
            binding.tagName = tagName
            if(clickable) binding.tagTextView.setOnClickListener { tagView ->
                onClickTag(tagName, selectedTags, tagView as TextView)
            }
            binding.executePendingBindings()
        }

        private fun onClickTag(tagName: String, selectedTags: MutableList<String>, tagView: TextView) {
            if(selectedTags.contains(tagName)) {
                selectedTags.remove(tagName)
                tagView.setBackgroundResource(R.drawable.outlined_tag_background)
                return
            }

            if(selectedTags.size < 3) {
                selectedTags.add(tagName)
                tagView.setBackgroundResource(R.drawable.filled_tag_background)
            }

            Log.d("선택된 태그", selectedTags.toString())
        }

        companion object {
            fun from(parent: ViewGroup) : SampleTagViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemSampleTagBinding.inflate(layoutInflater, parent, false)

                return SampleTagViewHolder(binding)
            }
        }
    }
}