package com.sigmai.stylemento.domain.entity

data class Piece(
    val id: Long,
    val url: String,
    val content: String,
    val tags: List<String>
)