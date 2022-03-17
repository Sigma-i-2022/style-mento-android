package com.sigmai.stylemento.data.model

data class ResponseWrapper<T> (
    val code: Int,
    val data: T,
    val message: String,
    val success: Boolean
    )