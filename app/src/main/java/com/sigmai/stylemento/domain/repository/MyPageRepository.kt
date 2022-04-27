package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.response.myPage.MyPageClient
import com.sigmai.stylemento.data.model.response.myPage.MyPageCrdi
import okhttp3.MultipartBody

interface MyPageRepository {
    fun getMyPageClient(email: String,) : MyPageClient
    fun putMyPageClient(email: String, userId: String, intro: String,) : Boolean
    fun getMyPageCrdi(email: String,) : MyPageCrdi
    fun postMyPageCrdi(email: String, userId: String, intro: String, expertYN: String, profileImage: MultipartBody.Part) : Boolean
    fun putMyPageCrdi(email: String, userId: String, intro: String) : Boolean
    fun postMyPageImage(memberEmail: String, uuid: String) : Boolean
}