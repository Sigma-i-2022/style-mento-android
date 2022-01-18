package com.sigmai.stylemento.global.util

import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TextureType
import java.lang.Exception

class TransformToEnumUtil {
    fun getItemCategoryType(position: Int) : ItemCategoryType {
        return when(position) {
            0 -> ItemCategoryType.NULL
            1 -> ItemCategoryType.TOP
            2 -> ItemCategoryType.PANTS
            3 -> ItemCategoryType.SHOES
            else -> throw Exception("It is not exist")
        }
    }
    fun getTextureType(position: Int) : TextureType {
        return when(position) {
            0 -> TextureType.NULL
            1 -> TextureType.COTTON
            2 -> TextureType.WOOL
            3 -> TextureType.POLYESTER
            4 -> TextureType.NYLON
            5 -> TextureType.ACRYL
            6 -> TextureType.RAYON
            7 -> TextureType.SLIK
            8 -> TextureType.CHIFFON
            9 -> TextureType.LINEN
            10 -> TextureType.SILKET
            11 -> TextureType.DENIM
            12 -> TextureType.LACE
            13 -> TextureType.TENCEL
            14 -> TextureType.TERRY
            15 -> TextureType.OXFORD
            16 -> TextureType.ANGORA
            17 -> TextureType.BUNTO
            18 -> TextureType.BOKASHI
            19 -> TextureType.TWEED
            20 -> TextureType.CODUROY
            21 -> TextureType.SUEDE
            22 -> TextureType.JACQUARD
            23 -> TextureType.RAISED
            24 -> TextureType.FUR
            25 -> TextureType.LEATHER
            else -> throw Exception("It is not exist")
        }
    }
    fun getFitType(position: Int) : FitType {
        return when(position) {
            0 -> FitType.NULL
            1 -> FitType.LOOSE
            2 -> FitType.OVER
            3 -> FitType.STANDARD
            4 -> FitType.SLIM
            else -> throw Exception("It is not exist")
        }
    }
}