package com.sigmai.stylemento.domain.entity

data class Piece(
    val id: Long,
    val imageUrl: String,
    val content: String,
    val tags: List<String>,
    val time: String,
    val height : String,
    val weight : String,
    val top : String,
    val pants : String,
    val shoes : String,
    val other : String,
    val isModified : Boolean
)