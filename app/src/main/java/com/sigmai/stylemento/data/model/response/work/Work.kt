package com.sigmai.stylemento.data.model.response.work

import com.sigmai.stylemento.data.model.response.lookBook.LookPage

data class Work (
    val bottomInfo : String?,
    val crdiWorkSeq : Long,
    val explanation : String?,
    val height : String?,
    val imagePathUrl : String?,
    val registDate : String?,
    val shoeInfo : String?,
    val topInfo : String?,
    val updateDate : String,
    val weight : String?,
    val keyword1: String?,
    val keyword2: String?,
    val keyword3: String?
) {
    fun toLookPage() : LookPage {
        return LookPage(
            bottomInfo ?: "",
            explanation ?: "",
            imagePathUrl ?: "",
            keyword1 ?: "",
            keyword2 ?: "",
            keyword3 ?: "",
            crdiWorkSeq,
            registDate ?: "",
            "",
            "N",
            topInfo ?: "",
            shoeInfo ?: "",
            updateDate
        )
    }
}