package com.sigmai.stylemento.data.repository.work

import com.sigmai.stylemento.data.api.CoordinatorWorkService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.work.Coordinator
import com.sigmai.stylemento.data.model.response.work.Work
import javax.inject.Inject

class WorkDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<CoordinatorWorkService>()

    fun getCrdiWork(workSeq: Long): Boolean {
        return service.getCrdiWork(workSeq).execute().body()?.success ?: false
    }

    fun postCrdiWork(
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
        return service.postCrdiWork(
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
        ).execute().body()?.success ?: false
    }

    fun getCrdiWorkAll(crdiEmail: String): List<Work> {
        return service.getCrdiWorkAll(crdiEmail).execute().body()!!.data
    }

    fun getCrdiList(email: String): List<Coordinator> {
        return service.getCrdiList(email).execute().body()!!.data
    }

    fun putCrdiWork(
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
    ): Boolean {
        return service.putCrdiWork(
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
        ).execute().body()!!.success
    }
}