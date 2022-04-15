package com.sigmai.stylemento.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ViewBankBottomSheetBinding
import com.sigmai.stylemento.global.util.BankUtil

class BankBottomSheet(val itemClick: (Int) -> Unit) : BottomSheetDialogFragment() {
    private var _binding: ViewBankBottomSheetBinding? = null
    private val binding get() = _binding!!

    val selectedBank = ArrayList<String>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ViewBankBottomSheetBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.bankRecycler.adapter = BankAdapter(BankUtil.getBankList(), selectedBank)

        binding.bankSelectionButton.setOnClickListener {
            if(selectedBank.size == 1)
                itemClick(BankUtil.getPosition(selectedBank[0]))
            else
                itemClick(-1)
            dialog?.dismiss()
        }
        return view
    }
}