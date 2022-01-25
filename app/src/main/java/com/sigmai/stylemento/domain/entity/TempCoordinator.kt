package com.sigmai.stylemento.domain.entity

data class TempCoordinator(
    val id: Long,
    val imageUrl: String?,
    val nickname: String,
    val email: String?,
    val introduction: String,
    val pieceList: List<Piece>,
    val rating: Int,
    val reviewList: List<Review>?,
    val isFavorite: Boolean,
    val numberOfHeart: Int,
    val tagList: List<String>
)