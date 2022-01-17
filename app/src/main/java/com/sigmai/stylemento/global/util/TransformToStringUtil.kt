package com.sigmai.stylemento.global.util

import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TextureType
import java.lang.Exception

class TransformToStringUtil {
    fun getItemCategoryString(position: Int) : String {
        return when(position) {
            0 -> ""
            1 -> "상의"
            2 -> "하의"
            3 -> "신발"
            else -> throw Exception("It is not exist")
        }
    }
    fun getTextureString(position: Int) : String {
        return when(position) {
            0 -> ""
            1 -> "TEXTURE1"
            2 -> "TEXTURE2"
            3 -> "TEXTURE3"
            4 -> "TEXTURE4"
            5 -> "TEXTURE5"
            else -> throw Exception("It is not exist")
        }
    }
    fun getFitString(position: Int) : String {
        return when(position) {
            0 -> ""
            1 -> "TYPE1"
            2 -> "TYPE2"
            3 -> "TYPE3"
            4 -> "TYPE4"
            5 -> "TYPE5"
            else -> throw Exception("It is not exist")
        }
    }
}