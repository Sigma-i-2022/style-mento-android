package com.sigmai.stylemento.data.model

import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TextureType

data class ReviewItem(
    val owner : String,
    var photoUrl: String = "",
    var star: Int = 0,
    var content: String = "",
    var time: String = ""
)