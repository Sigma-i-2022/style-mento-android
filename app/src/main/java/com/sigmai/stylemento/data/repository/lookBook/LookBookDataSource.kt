package com.sigmai.stylemento.data.repository.lookBook

import com.sigmai.stylemento.data.api.ClientLookBookService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.request.lookbook.StringWrapper
import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import okhttp3.MultipartBody
import javax.inject.Inject

class LookBookDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<ClientLookBookService>()

    fun getLookPage(lookSeq: Long) : LookPage{
        return service.getLookPage(lookSeq).execute().body()!!.data
    }

    fun postLookPage(memberEmail: String, explanation: String, keyword1: String, keyword2: String, keyword3: String, topInfo: String, bottomInfo: String, shoeInfo: String, uuid: String) : Boolean{
        return service.postLookPage(memberEmail, explanation, keyword1, keyword2, keyword3, topInfo, bottomInfo, shoeInfo, uuid).execute().body()?.success ?: false
    }

    fun getLookPageAll(email: String, page: Int) : List<LookPage>{
        return service.getLookPageAll(email, page).execute().body()!!.data
    }

    fun deleteLookPage(lookSeq: Long) : Boolean{
        return service.deleteLookPage(lookSeq).execute().body()?.success ?: false
    }

    fun putLookPageImage(lookSeq: Long, uuid: String) : Boolean{
        return service.putLookPageImage(lookSeq, StringWrapper(uuid)).execute().body()?.success ?: false
    }

    fun putLookPageInfo(lookSeq: Long, clientEmail: String, explanation: String, keyword1: String, keyword2: String, keyword3: String, topInfo: String, bottomInfo: String, shoeInfo: String) : Boolean {
        return service.putLookPageInfo(lookSeq, clientEmail, explanation, keyword1, keyword2, keyword3, topInfo, bottomInfo, shoeInfo).execute().body()?.success ?: false
    }

    fun postLookPageReport(lookSeq: Long, reason: String) : Boolean{
        return service.postLookPageReport(lookSeq, reason).execute().body()?.success ?: false
    }

    fun getLookPageReportAll() : List<LookPage>{
        return service.getLookPageReportAll().execute().body()!!.data
    }
}