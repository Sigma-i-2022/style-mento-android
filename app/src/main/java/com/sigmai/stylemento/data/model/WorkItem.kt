package com.sigmai.stylemento.data.model

import android.net.Uri
import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TagType
import com.sigmai.stylemento.global.constant.TextureType

data class WorkItem(
    var photoUrl: Uri? = Uri.EMPTY,
    var detail : String = "",
    var height : String = "",
    var weight : String = "",
    var top : String = "",
    var pants : String = "",
    var shoes : String = "",
    var other : String = "",
    var tags : MutableList<TagType> = mutableListOf(),
    var time : String = "",
    var isModified : Boolean = false
)