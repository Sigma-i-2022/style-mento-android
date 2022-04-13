package com.sigmai.stylemento.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sigmai.stylemento.R
import com.sigmai.stylemento.global.util.BankUtil

class BankBottomSheet(val selectedBank : MutableLiveData<String>) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.view_bank_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bankRecycler = view.findViewById<RecyclerView>(R.id.bank_recycler)
        bankRecycler?.adapter = BankAdapter(BankUtil.getBankList(), selectedBank)

        selectedBank.observe(this){
            dismiss()
        }
    }
}