package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.response.submall.SubMall
import com.sigmai.stylemento.data.model.response.submall.SubMallAll

interface SubMallRepository {
    fun deleteSubMall(crdiEmail : String) : Boolean
    fun getSubMall(crdiEmail : String) : SubMall
    fun postSubMall(bank : String, accountNumber : String, holderName : String, crdiEmail : String, companyName : String, representativeName : String, type : String, businessNumber : String?) : SubMall
    fun putSubMall(crdiEmail : String, bank : String, accountNumber : String, holderName : String, companyName : String, representativeName : String, businessNumber : String) : SubMall
    fun getSubMallAll() : List<SubMallAll>
}