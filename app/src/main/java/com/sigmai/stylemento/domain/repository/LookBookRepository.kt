package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import okhttp3.MultipartBody

interface LookBookRepository {
    fun getLookPage(lookSeq: Long) : LookPage
    fun postLookPage(memberEmail: String, explanation: String, keyword1: String, keyword2: String, keyword3: String, topInfo: String, bottomInfo: String, shoeInfo: String, imageFile: MultipartBody.Part) : Boolean
    fun getLookPageAll(email: String) : List<LookPage>
    fun deleteLookPage(lookSeq: Long) : Boolean
    fun putLookPageImage(lookSeq: Long, requestImage: MultipartBody.Part) : Boolean
    fun putLookPageInfo(lookSeq: Long, memberEmail: String, explanation: String, keyword1: String, keyword2: String, keyword3: String, topInfo: String, bottomInfo: String, shoeInfo: String) : Boolean
    fun postLookPageReport(lookSeq: Long, reason: String) : Boolean
    fun getLookPageReportAll() : List<LookPage>
}