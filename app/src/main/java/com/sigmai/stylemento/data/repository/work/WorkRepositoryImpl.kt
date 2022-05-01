package com.sigmai.stylemento.data.repository.work

import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.data.model.response.work.Coordinator
import com.sigmai.stylemento.data.model.response.work.Work
import com.sigmai.stylemento.domain.repository.WorkRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class WorkRepositoryImpl @Inject constructor(private val dataSource: WorkDataSource) :
    WorkRepository {
    override fun getCrdiWork(workSeq: Long): LookPage {
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
        keyword1: String,
        keyword2: String,
        keyword3: String,
        uuid: String
    ): Boolean {
        return dataSource.postCrdiWork(
            crdiEmail,
            explanation,
            weight,
            height,
            topInfo,
            bottomInfo,
            shoeInfo,
            keyword1,
            keyword2,
            keyword3,
            uuid
        )
    }

    override fun getCrdiWorkAll(crdiEmail: String): List<Work> {
        return dataSource.getCrdiWorkAll(crdiEmail)
    }

    override fun getCrdiList(email: String): List<Coordinator> {
        return dataSource.getCrdiList(email)
    }

    override fun putCrdiWork(
        workSeq: Long,
        crdiEmail: String,
        explanation: String,
        weight: String,
        height: String,
        topInfo: String,
        bottomInfo: String,
        shoeInfo: String,
        keyword1: String,
        keyword2: String,
        keyword3: String
    ) : Boolean {
        return dataSource.putCrdiWork(
            workSeq,
            crdiEmail,
            explanation,
            weight,
            height,
            topInfo,
            bottomInfo,
            shoeInfo,
            keyword1,
            keyword2,
            keyword3
        )
    }
}