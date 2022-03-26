package com.sigmai.stylemento.data.model.response.work

import com.sigmai.stylemento.data.model.response.lookBook.LookPage

data class Work (
    val bottomInfo : String,
    val crdiWorkSeq : Long,
    val explanation : String,
    val height : String,
    val imagePathUrl : String,
    val registDate : String,
    val shoeInfo : String,
    val topInfo : String,
    val updateDate : String,
    val weight : String,
) {
    fun toLookPage() : LookPage {
        return LookPage(
            bottomInfo,
            explanation,
            imagePathUrl,
            "",
            "",
            "",
            crdiWorkSeq,
            registDate,
            "",
            "N",
            topInfo,
            shoeInfo,
            updateDate
        )
    }
}