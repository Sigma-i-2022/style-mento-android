package com.sigmai.stylemento.domain.entity

import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.data.model.response.work.Work

data class Piece(
    val id: Long,
    val imageUrl: String,
    val content: String,
    val tags: List<String>,
    val time: String,
    val height : String,
    val weight : String,
    val top : String,
    val bottom : String,
    val shoes : String,
    val other : String? = null,
    val isModified : Boolean = false,
    val isClient: Boolean = true
) {
    companion object {
        fun from(lookPage: LookPage) : Piece {
            return Piece(
                id = lookPage.lookPageSeq,
                imageUrl = lookPage.imagePathUrl,
                content = lookPage.explanation,
                tags = listOf(
                    lookPage.keyword1,
                    lookPage.keyword2,
                    lookPage.keyword3
                ),
                time = lookPage.registDate,
                height = "0",
                weight = "0",
                top = lookPage.topInfo,
                bottom = lookPage.bottomInfo,
                shoes = lookPage.shoeInfo,
                isClient = true
            )
        }

        fun from(work: Work) : Piece {
            return Piece(
                id = work.crdiWorkSeq,
                imageUrl = work.imagePathUrl ?: "",
                content = work.explanation ?: "",
                tags = listOf(),
                time = work.registDate ?: "",
                height = work.height ?: "",
                weight = work.weight ?: "",
                top = work.topInfo ?: "",
                bottom = work.bottomInfo ?: "",
                shoes = work.shoeInfo ?: "",
                isClient = false
            )
        }
    }
}