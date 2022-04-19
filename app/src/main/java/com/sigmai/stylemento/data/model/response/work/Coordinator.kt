package com.sigmai.stylemento.data.model.response.work

data class Coordinator(
    val id: String,
    val imagePathUrl: String,
    val imageWorkImageList: List<String>,
    val stag1: String?,
    val stag2: String?,
    val stag3: String?,
    val star: Int
)
