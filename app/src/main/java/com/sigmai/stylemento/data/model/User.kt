package com.sigmai.stylemento.data.model

import android.net.Uri
import com.sigmai.stylemento.global.constant.UserType

data class User(
    val nickname: String,
    val email: String,
    var profile: Uri = Uri.EMPTY,
    var introduction: String = "",
    var closetItems: MutableList<ClosetItem> = mutableListOf(),
    var lookbookItems: MutableList<LookbookItem> = mutableListOf()
)