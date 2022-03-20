package com.sigmai.stylemento.data.repository.myPage

import com.sigmai.stylemento.data.api.MyPageService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.myPage.MyPageClient
import com.sigmai.stylemento.data.model.response.myPage.MyPageCrdi
import okhttp3.MultipartBody
import javax.inject.Inject

class MyPageDataSource @Inject constructor(){
    private val service = RetrofitServiceFactory.createService<MyPageService>()

    fun getMyPageClient(email: String,) : MyPageClient{
        return service.getMyPageClient(email).execute().body()!!.data
    }

    fun putMyPageClient(email: String, userId: String, intro: String,) : Boolean{
        return service.putMyPageClient(email, userId, intro).execute().body()?.success ?: false
    }

    fun getMyPageCrdi(email: String,) : MyPageCrdi{
        return service.getMyPageCrdi(email).execute().body()!!.data
    }

    fun postMyPageCrdi(email: String, userId: String, intro: String, expertYN: String, profileImage: MultipartBody.Part) : Boolean{
        return service.postMyPageCrdi(email, userId, intro, expertYN, profileImage).execute().body()?.success ?: false
    }

    fun putMyPageCrdi(email: String, userId: String, intro: String) : Boolean {
        return service.putMyPageCrdi(email, userId, intro).execute().body()?.success ?: false
    }

    fun postMyPageImage(memberEmail: String, memberImageFile: MultipartBody.Part) : Boolean{
        return service.postMyPageImage(memberEmail, memberImageFile).execute().body()?.success ?: false
    }
}