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
            TextureType.COTTON -> "면"
            TextureType.WOOL -> "울"
            TextureType.POLYESTER -> "폴리에스테르"
            TextureType.NYLON -> "나일론"
            TextureType.ACRYL -> "아크릴"
            TextureType.RAYON -> "레이온"
            TextureType.SLIK -> "실크"
            TextureType.CHIFFON -> "쉬폰"
            TextureType.LINEN -> "린넨"
            TextureType.SILKET -> "실켓"
            TextureType.DENIM -> "데님"
            TextureType.LACE -> "레이스"
            TextureType.TENCEL -> "텐셀"
            TextureType.TERRY -> "쭈리원단"
            TextureType.OXFORD -> "옥스퍼드"
            TextureType.ANGORA -> "앙고라"
            TextureType.BUNTO -> "분또"
            TextureType.BOKASHI -> "보카시"
            TextureType.TWEED -> "트위드"
            TextureType.CODUROY -> "코듀로이"
            TextureType.SUEDE -> "스웨이드"
            TextureType.JACQUARD -> "자카드"
            TextureType.RAISED -> "기모"
            TextureType.FUR -> "모피"
            TextureType.LEATHER -> "가죽"
            else -> throw Exception("It is not exist")
        }
    }
    fun getFitString(type : FitType) : String {
        return when(type) {
            FitType.NULL -> ""
            FitType.LOOSE -> "루즈"
            FitType.OVER -> "오버"
            FitType.STANDARD -> "스탠다드"
            FitType.SLIM -> "슬림"
            else -> throw Exception("It is not exist")
        }
    }
}