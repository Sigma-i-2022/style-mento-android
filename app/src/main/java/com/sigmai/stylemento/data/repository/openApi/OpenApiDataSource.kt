package com.sigmai.stylemento.data.repository.openApi

import com.sigmai.stylemento.data.api.OpenApiService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.AccountInfo
import javax.inject.Inject

class OpenApiDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<OpenApiService>()

    fun getAccount(crdiSeq : Long) : AccountInfo{
        return service.getAccount(crdiSeq).execute().body()!!.data
    }
    fun postRealName(crdiSeq : Long, bankCode : String, bankAccount : String, realName : String, birthday : String) : Boolean{
        return service.postRealName(crdiSeq, bankCode, bankAccount, realName, birthday).execute().body()?.success ?: false
    }
    fun postToken() : Boolean{
        return service.postToken().execute().body()?.success ?: false
    }
}