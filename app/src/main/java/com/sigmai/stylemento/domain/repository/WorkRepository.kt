package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.response.work.Work
import okhttp3.MultipartBody

interface WorkRepository {
    fun getCrdiWork(workSeq : Long) : Boolean
    fun postCrdiWork(crdiEmail : String, explanation : String, weight : String, height : String, topInfo : String, bottomInfo : String, shoeInfo : String, imageFile: MultipartBody.Part) : Boolean
    fun getCrdiWorkAll(crdiEmail : String) : List<Work>
}