package com.sigmai.stylemento.global.util

import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TagType
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

    fun getTagType(position: Int) : TagType {
        return when(position){
            0 -> TagType.NULL
            1 -> TagType.CASULAL
            2 -> TagType.STREET
            3 -> TagType.MODERN
            4 -> TagType.FEMININE
            5 -> TagType.DANDY
            6 -> TagType.MINIMAL
            7 -> TagType.MAXIMAL
            8 -> TagType.CITY
            9 -> TagType.AMERICANCASUAL
            10 -> TagType.CLASSIC
            11 -> TagType.STUDENT
            12 -> TagType.OFFICE
            13 -> TagType.DATE
            14 -> TagType.BLINDDATE
            15 -> TagType.TRAVEL
            16 -> TagType.PARTY
            17 -> TagType.COUPLE
            18 -> TagType.GUEST
            19 -> TagType.SPRING
            20 -> TagType.SUMMER
            21 -> TagType.AUTUMN
            22 -> TagType.WINTER
            23 -> TagType.RAIN
            else -> throw Exception("It is not exist")
        }
    }
}