package com.sigmai.stylemento.domain.entity

data class Piece(
    val id: Long,
    val content: String,
    val tags: List<String>
)