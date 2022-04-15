package com.sigmai.stylemento.ui.setting

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ItemBankBinding
import com.sigmai.stylemento.databinding.ItemTimeSelectorBinding


class BankAdapter(
    private val bankList: List<String>,
    private val selectedBank: ArrayList<String>
) : RecyclerView.Adapter<BankAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bankList[position], selectedBank)
    }

    override fun getItemCount(): Int {
        return bankList.size
    }

    class ViewHolder(val binding: ItemBankBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, selectedBank: ArrayList<String>) {
            binding.item = item
            binding.bankSelectorText.setOnClickListener {   tagView ->
                onClickBank(item, selectedBank, tagView as TextView)
            }
            binding.executePendingBindings()
        }

        private fun onClickBank(
            item: String,
            selectedBank: ArrayList<String>,
            timeView: TextView
        ) {
            if (selectedBank.contains(item)) {
                selectedBank.remove(item)
                timeView.setBackgroundResource(R.drawable.button_background_type_1)
                return
            }

            if (selectedBank.size < 1) {
                selectedBank.add(item)
                timeView.setBackgroundResource(R.drawable.button_background_type_2)
            }
        }

        companion object {
            fun from(parent: ViewGroup): BankAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemBankBinding.inflate(layoutInflater, parent, false)

                return BankAdapter.ViewHolder(binding)
            }
        }
    }

}
