package com.sigmai.stylemento.global.util

import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TextureType
import java.lang.Exception

class TransformToStringUtil {
    fun getItemCategoryString(type : ItemCategoryType) : String {
        return when(type) {
            ItemCategoryType.NULL -> ""
            ItemCategoryType.TOP -> "상의"
            ItemCategoryType.PANTS -> "하의"
            ItemCategoryType.SHOES -> "신발"
            else -> throw Exception("It is not exist")
        }
    }
    fun getTextureString(type : TextureType) : String {
        return when(type) {
            TextureType.NULL -> ""
            TextureType.TEXTURE1 -> "TEXTURE1"
            TextureType.TEXTURE2 -> "TEXTURE2"
            TextureType.TEXTURE3 -> "TEXTURE3"
            TextureType.TEXTURE4 -> "TEXTURE4"
            TextureType.TEXTURE5 -> "TEXTURE5"
            else -> throw Exception("It is not exist")
        }
    }
    fun getFitString(type : FitType) : String {
        return when(type) {
            FitType.NULL -> ""
            FitType.TYPE1 -> "TYPE1"
            FitType.TYPE2 -> "TYPE2"
            FitType.TYPE3 -> "TYPE3"
            FitType.TYPE4 -> "TYPE4"
            FitType.TYPE5 -> "TYPE5"
            else -> throw Exception("It is not exist")
        }
    }
}