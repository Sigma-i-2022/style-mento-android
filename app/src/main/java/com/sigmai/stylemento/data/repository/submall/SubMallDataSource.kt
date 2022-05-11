package com.sigmai.stylemento.data.repository.submall

import com.sigmai.stylemento.data.api.SubmallService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.submall.SubMall
import com.sigmai.stylemento.data.model.response.submall.SubMallAll
import javax.inject.Inject

class SubMallDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<SubmallService>()

    fun deleteSubMall(crdiEmail : String) : Boolean {
        return service.deleteSubMall(crdiEmail).execute().body()?.success ?: false
    }
    fun getSubMall(crdiEmail : String) : SubMall {
        return service.getSubMall(crdiEmail).execute().body()!!.data
    }
    fun postSubMall(bank : String, accountNumber : String, holderName : String, crdiEmail : String, companyName : String, representativeName : String, type : String, businessNumber : String) : SubMall{
        return service.postSubMall(bank, accountNumber, holderName, crdiEmail, companyName, representativeName, type, businessNumber).execute().body()!!.data
    }
    fun putSubMall(crdiEmail : String, bank : String, accountNumber : String, holderName : String, companyName : String, representativeName : String, businessNumber : String) : SubMall{
        return service.putSubMall(crdiEmail, bank, accountNumber, holderName, companyName, representativeName, businessNumber).execute().body()!!.data
    }
    fun getSubMallAll() : List<SubMallAll>{
        return service.getSubMallAll().execute().body()!!.data
    }
}