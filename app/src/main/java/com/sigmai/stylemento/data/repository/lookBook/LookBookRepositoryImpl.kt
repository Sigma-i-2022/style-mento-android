package com.sigmai.stylemento.data.repository.lookBook

import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.domain.repository.LookBookRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class LookBookRepositoryImpl @Inject constructor(private val dataSource: LookBookDataSource) :
    LookBookRepository {
    override fun getLookPage(lookSeq: Long): LookPage {
        return dataSource.getLookPage(lookSeq)
    }

    override fun postLookPage(
        memberEmail: String,
        explanation: String,
        keyword1: String,
        keyword2: String,
        keyword3: String,
        topInfo: String,
        bottomInfo: String,
        shoeInfo: String,
        imageFile: MultipartBody.Part
    ): Boolean {
        return dataSource.postLookPage(memberEmail, explanation, keyword1, keyword2, keyword3, topInfo, bottomInfo, shoeInfo, imageFile)
    }

    override fun getLookPageAll(email: String, page: Int): List<LookPage> {
        return dataSource.getLookPageAll(email, page)
    }
    override fun deleteLookPage(lookSeq: Long): Boolean {
        return dataSource.deleteLookPage(lookSeq)
    }
    override fun putLookPageImage(lookSeq: Long, requestImage: MultipartBody.Part): Boolean {
        return dataSource.putLookPageImage(lookSeq, requestImage)
    }
    override fun putLookPageInfo(
        lookSeq: Long,
        memberEmail: String,
        explanation: String,
        keyword1: String,
        keyword2: String,
        keyword3: String,
        topInfo: String,
        bottomInfo: String,
        shoeInfo: String
    ): Boolean {
        return dataSource.putLookPageInfo(lookSeq, memberEmail, explanation, keyword1, keyword2, keyword3, topInfo, bottomInfo, shoeInfo)
    }

    override fun postLookPageReport(lookSeq: Long, reason: String): Boolean {
        return dataSource.postLookPageReport(lookSeq, reason)
    }
    override fun getLookPageReportAll(): List<LookPage> {
        return dataSource.getLookPageReportAll()
    }
}