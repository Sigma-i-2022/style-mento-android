package com.sigmai.stylemento.data.model

import android.net.Uri
import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TagType
import com.sigmai.stylemento.global.constant.TextureType

data class LookbookItem(
    val owner : String,
    var photoUrl: Uri = Uri.EMPTY,
    var detail : String = "",
    var top : String = "",
    var pants : String = "",
    var shoes : String = "",
    var tags : List<TagType> = listOf(),
    var time : String = "",
    var idx : Int = 0
)