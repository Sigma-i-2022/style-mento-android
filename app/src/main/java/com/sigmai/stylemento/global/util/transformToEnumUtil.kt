package com.sigmai.stylemento.global.util

import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TextureType
import java.lang.Exception

class transformToEnumUtil {
    fun getItemCategoryType(position: Int) : ItemCategoryType {
        return when(position + 1) {
            0 -> ItemCategoryType.NULL
            1 -> ItemCategoryType.TOP
            2 -> ItemCategoryType.PANTS
            3 -> ItemCategoryType.SHOES
            else -> throw Exception("It is not exist")
        }
    }
    fun getTextureType(position: Int) : TextureType {
        return when(position + 1) {
            0 -> TextureType.NULL
            1 -> TextureType.TEXTURE1
            2 -> TextureType.TEXTURE2
            3 -> TextureType.TEXTURE3
            4 -> TextureType.TEXTURE4
            5 -> TextureType.TEXTURE5
            else -> throw Exception("It is not exist")
        }
    }
    fun getFitType(position: Int) : FitType {
        return when(position + 1) {
            0 -> FitType.NULL
            1 -> FitType.TYPE1
            2 -> FitType.TYPE2
            3 -> FitType.TYPE3
            4 -> FitType.TYPE4
            5 -> FitType.TYPE5
            else -> throw Exception("It is not exist")
        }
    }
}