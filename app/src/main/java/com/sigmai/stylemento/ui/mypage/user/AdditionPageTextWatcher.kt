package com.sigmai.stylemento.ui.mypage.user

import android.text.Editable
import android.text.TextWatcher
import com.sigmai.stylemento.data.model.LookbookItem

class AdditionPageTextWatcher(var targetItem: LookbookItem, val target: String) : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        when(target) {
            "detail" -> targetItem.detail = s!!.toString()
            "top" -> targetItem.top = s!!.toString()
            "pants" -> targetItem.pants = s!!.toString()
            "shoes" -> targetItem.shoes = s!!.toString()
            "other" -> targetItem.other = s!!.toString()
            else -> return
        }
    }
    override fun afterTextChanged(s: Editable?) {}
}