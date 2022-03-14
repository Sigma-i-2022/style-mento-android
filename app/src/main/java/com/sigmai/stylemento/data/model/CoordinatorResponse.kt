package com.sigmai.stylemento.data.model

import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.domain.entity.Review

data class CoordinatorResponse(
    val id: Long,
    val imageUrl: String?,
    val nickname: String,
    val email: String?,
    val introduction: String,
    var pieceList: List<Piece>,
    val rating: Int,
    val reviewList: List<Review>?,
    val isFavorite: Boolean,
    val numberOfHeart: Int,
    val tagList: List<String>
)
