package com.sigmai.stylemento.data.repository.work

import com.sigmai.stylemento.data.api.CoordinatorWorkService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.work.Work
import okhttp3.MultipartBody
import javax.inject.Inject

class WorkDataSource @Inject constructor(){
    private val service = RetrofitServiceFactory.createService<CoordinatorWorkService>()

    fun getCrdiWork(workSeq : Long) : Boolean{
        return service.getCrdiWork(workSeq).execute().body()?.success ?: false
    }

    fun postCrdiWork(crdiEmail : String, explanation : String, weight : String, height : String, topInfo : String, bottomInfo : String, shoeInfo : String, imageFile: MultipartBody.Part) : Boolean{
        return service.postCrdiWork(crdiEmail, explanation, weight, height, topInfo, bottomInfo, shoeInfo, imageFile).execute().body()?.success ?: false
    }

    fun getCrdiWorkAll(crdiEmail : String) : List<Work>{
        return service.getCrdiWorkAll(crdiEmail).execute().body()!!.data
    }
}