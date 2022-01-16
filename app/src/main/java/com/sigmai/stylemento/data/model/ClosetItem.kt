package com.sigmai.stylemento.data.model

import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TextureType

data class ClosetItem(
    val photoUrl: String,
    var category : ItemCategoryType = ItemCategoryType.NULL,
    var itemName : String = "",
    var brand : String = "",
    var texture : TextureType = TextureType.NULL,
    var size : String = "",
    var myFit : FitType = FitType.NULL
)