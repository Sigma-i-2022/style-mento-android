package com.sigmai.stylemento.global.base

import com.sigmai.stylemento.global.constant.TagType

interface HavingTag {
    fun setTags(tagTypes: MutableList<TagType>)
}

interface HavingTag2 {
    fun setTagList(tagList: List<String>)
}