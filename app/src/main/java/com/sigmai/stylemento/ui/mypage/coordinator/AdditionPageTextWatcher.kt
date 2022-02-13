package com.sigmai.stylemento.ui.mypage.coordinator

import android.text.Editable
import android.text.TextWatcher
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.data.model.WorkItem

class AdditionPageTextWatcher(var targetItem: WorkItem, val target: String) : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        when(target) {
            "detail" -> targetItem.detail = s!!.toString()
            "top" -> targetItem.top = s!!.toString()
            "pants" -> targetItem.pants = s!!.toString()
            "shoes" -> targetItem.shoes = s!!.toString()
            else -> return
        }
    }
    override fun afterTextChanged(s: Editable?) {}
}