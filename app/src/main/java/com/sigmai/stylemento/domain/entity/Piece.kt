package com.sigmai.stylemento.domain.entity

data class Piece(
    val id: Long,
    val imageUrl: String,
    val content: String,
    val tags: List<String>,
    val time: String,
    var height : String = "",
    var weight : String = "",
    var top : String = "",
    var pants : String = "",
    var shoes : String = "",
    var other : String = "",
    var isModified : Boolean = false
)