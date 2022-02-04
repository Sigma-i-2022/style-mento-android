package com.sigmai.stylemento.data.model

import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.ReviewType
import com.sigmai.stylemento.global.constant.TextureType

data class ReviewItem(
    val type: Int,
    val owner : String,
    var content: String = "",
    var photoUrl: String = "",
    var star: Int = 0,
    var time: String = "",
    var height : Float = 0f,
    var weight : Float = 0f
)