package com.sigmai.stylemento.data.repository.work

import com.sigmai.stylemento.data.model.response.work.Work
import com.sigmai.stylemento.domain.repository.WorkRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class WorkRepositoryImpl @Inject constructor(private val dataSource: WorkDataSource) :
    WorkRepository {
    override fun getCrdiWork(workSeq: Long): Boolean {
        return dataSource.getCrdiWork(workSeq)
    }
    override fun postCrdiWork(
        crdiEmail: String,
        explanation: String,
        weight: String,
        height: String,
        topInfo: String,
        bottomInfo: String,
        shoeInfo: String,
        imageFile: MultipartBody.Part
    ): Boolean {
        return dataSource.postCrdiWork(crdiEmail, explanation, weight, height, topInfo, bottomInfo, shoeInfo, imageFile)
    }

    override fun getCrdiWorkAll(crdiEmail: String): List<Work> {
        return dataSource.getCrdiWorkAll(crdiEmail)
    }
}