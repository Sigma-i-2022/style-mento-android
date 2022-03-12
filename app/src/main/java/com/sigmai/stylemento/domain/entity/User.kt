package com.sigmai.stylemento.domain.entity

data class User(
    val id: Long,
    val imageUrl: String?,
    val nickname: String,
    val email: String?,
    val introduction: String,
    val lookbookItemList: List<LookbookItem>,
    val receiptList: List<Receipt>
)