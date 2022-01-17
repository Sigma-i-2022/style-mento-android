package com.sigmai.stylemento.data.model

import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TextureType

data class ClosetItem(
    val owner : String,
    val photoUrl: String,
    var category : String = "",
    var itemName : String = "",
    var brand : String = "",
    var texture : String = "",
    var size : String = "",
    var myFit : String = ""
)