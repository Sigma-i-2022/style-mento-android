package com.sigmai.stylemento.data.model

import com.sigmai.stylemento.global.constant.TagType

data class Coordinator(
    val nickname: String,
    var email: String = "",
    var introduction: String = "",
    var likes: Int = 0,
    var styleTags: MutableList<TagType> = mutableListOf(),
    var workItems: MutableList<WorkItem> = mutableListOf(),
    var reviews: MutableList<ReviewItem> = mutableListOf()
)