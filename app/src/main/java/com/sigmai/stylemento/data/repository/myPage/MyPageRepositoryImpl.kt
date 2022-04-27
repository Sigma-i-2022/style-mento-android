package com.sigmai.stylemento.data.repository.myPage

import com.sigmai.stylemento.data.model.response.myPage.MyPageClient
import com.sigmai.stylemento.data.model.response.myPage.MyPageCrdi
import com.sigmai.stylemento.domain.repository.MyPageRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class MyPageRepositoryImpl @Inject constructor(private val dataSource: MyPageDataSource) :
    MyPageRepository {
    override fun getMyPageClient(email: String): MyPageClient {
        return dataSource.getMyPageClient(email)
    }
    override fun putMyPageClient(email: String, userId: String, intro: String): Boolean {
        return dataSource.putMyPageClient(email, userId, intro)
    }
    override fun getMyPageCrdi(email: String): MyPageCrdi {
        return dataSource.getMyPageCrdi(email)
    }
    override fun postMyPageCrdi(
        email: String,
        userId: String,
        intro: String,
        expertYN: String,
        profileImage: MultipartBody.Part
    ): Boolean {
        return dataSource.postMyPageCrdi(email, userId, intro, expertYN, profileImage)
    }

    override fun putMyPageCrdi(email: String, userId: String, intro: String): Boolean {
        return dataSource.putMyPageCrdi(email, userId, intro)
    }
    override fun postMyPageImage(memberEmail: String, uuid: String): Boolean {
        return dataSource.postMyPageImage(memberEmail, uuid)
    }
}