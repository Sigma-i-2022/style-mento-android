package com.sigmai.stylemento.ui.mypage.model

data class StyleTag(
    val categoryName: String? = null,
    val tagName: String? = null
) {
    companion object {
        const val CATEGORY = 0
        const val TAG = 1
    }

    fun getType(): Int {
        return if(categoryName != null) CATEGORY else TAG
    }
}
