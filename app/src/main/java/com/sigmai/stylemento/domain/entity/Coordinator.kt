package com.sigmai.stylemento.domain.entity

import com.sigmai.stylemento.data.model.CoordinatorResponse

data class Coordinator(
    val id: Long = 0,
    val imageUrl: String?,
    val nickname: String,
    val email: String? = "",
    val introduction: String = "",
    val pieceList: List<Piece> = listOf(),
    val pieceImages: List<String>,
    val rating: Int,
    val reviewList: List<Review>? = listOf(),
    val tagList: List<String>
) {
    companion object {
        fun from(coordinatorResponse: com.sigmai.stylemento.data.model.response.work.Coordinator) : Coordinator {
            val tagList = mutableListOf(
                coordinatorResponse.stag1,
                coordinatorResponse.stag2,
                coordinatorResponse.stag3
            ).filterNotNull()

            return Coordinator(
                imageUrl = coordinatorResponse.imagePathUrl,
                nickname = coordinatorResponse.id,
                pieceImages = coordinatorResponse.imageWorkImageList,
                rating = coordinatorResponse.star,
                tagList = tagList
            )
        }
    }
}