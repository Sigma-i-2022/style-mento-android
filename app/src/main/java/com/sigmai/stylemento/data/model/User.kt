package com.sigmai.stylemento.data.model

import com.sigmai.stylemento.global.constant.UserType

data class User(
    var userType: UserType = UserType.NORMAL,
    val nickname: String,
    val email: String,
    var introduction: String = "",
    var closetItems: MutableList<ClosetItem> = mutableListOf(),
    var lookbookItems: MutableList<LookbookItem> = mutableListOf()
)