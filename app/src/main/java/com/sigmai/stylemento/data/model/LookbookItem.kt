package com.sigmai.stylemento.data.model

import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TagType
import com.sigmai.stylemento.global.constant.TextureType

data class LookbookItem(
    val owner : String,
    var photoUrl: String,
    var deltail : String = "",
    var top : String = "",
    var topInfo : String = "",
    var pants : String = "",
    var pantsInfo : String = "",
    var shoes : String = "",
    var shoesInfo : String = "",
    var tags : MutableList<TagType> = mutableListOf()
)