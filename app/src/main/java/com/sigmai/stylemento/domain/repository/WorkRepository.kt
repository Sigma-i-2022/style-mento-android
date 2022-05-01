package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.response.work.Coordinator
import com.sigmai.stylemento.data.model.response.work.Work
import okhttp3.MultipartBody

interface WorkRepository {
    fun getCrdiWork(workSeq: Long): Boolean
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
    ): Boolean
    fun getCrdiWorkAll(crdiEmail: String): List<Work>
    fun getCrdiList(email: String): List<Coordinator>
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
    ) : Boolean
}