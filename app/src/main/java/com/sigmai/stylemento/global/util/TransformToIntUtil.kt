package com.sigmai.stylemento.global.util

import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TagType
import com.sigmai.stylemento.global.constant.TextureType
import java.lang.Exception

class TransformToIntUtil {

    fun getTagInt(type : TagType) : Int {
        return when(type) {
            TagType.NULL -> 0
            TagType.CASULAL -> 1
            TagType.STREET -> 2
            TagType.MODERN -> 3
            TagType.FEMININE -> 4
            TagType.DANDY -> 5
            TagType.MINIMAL -> 6
            TagType.MAXIMAL -> 7
            TagType.CITY -> 8
            TagType.AMERICANCASUAL -> 9
            TagType.CLASSIC -> 10
            TagType.STUDENT -> 11
            TagType.OFFICE -> 12
            TagType.DATE -> 13
            TagType.BLINDDATE -> 14
            TagType.TRAVEL -> 15
            TagType.PARTY -> 16
            TagType.COUPLE -> 17
            TagType.GUEST -> 18
            TagType.SPRING -> 19
            TagType.SUMMER -> 20
            TagType.AUTUMN -> 21
            TagType.WINTER -> 22
            TagType.RAIN -> 23
            else -> throw Exception("It is not exist")
        }
    }
}