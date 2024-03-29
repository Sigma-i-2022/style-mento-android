package com.sigmai.stylemento.data.model

import android.net.Uri
import com.sigmai.stylemento.global.constant.ReviewType
import com.sigmai.stylemento.global.constant.TagType

data class Coordinator(
    val nickname: String,
    var email: String = "",
    var profile: Uri? = Uri.EMPTY,
    var introduction: String = "",
    var likes: Int = 0,
    var styleTags: MutableList<TagType> = mutableListOf(),
    var workItems: MutableList<WorkItem> = mutableListOf(),
    var reviews: MutableList<ReviewItem> = mutableListOf(ReviewItem(ReviewType.NORMAL, "user1", "", "",4, "Hello World!" +
            "Hello World!" +
            "Hello World!" +
            "Hello World!" +
            "Hello World!" +
            "Hello World!" +
            "Hello World!" +
            "Hello World!" +
            "Hello World!", "0000.00.00"),
        ReviewItem(ReviewType.NORMAL, "user2", "", "",5, "Hello World!", "0000.00.00")),
    var receipts: MutableList<Receipt> = mutableListOf()
)