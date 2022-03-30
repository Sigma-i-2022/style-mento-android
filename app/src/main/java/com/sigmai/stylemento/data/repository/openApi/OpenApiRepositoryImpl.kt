package com.sigmai.stylemento.data.repository.openApi

import com.sigmai.stylemento.data.model.AccountInfo
import com.sigmai.stylemento.domain.repository.OpenApiRepository
import javax.inject.Inject

class OpenApiRepositoryImpl@Inject constructor(private val dataSource: OpenApiDataSource) : OpenApiRepository {
    override fun getAccount(crdiSeq : Long) : AccountInfo {
        return dataSource.getAccount(crdiSeq)
    }
    override fun postRealName(crdiSeq : Long, bankCode : String, bankAccount : String, realName : String, birthday : String) : Boolean{
        return dataSource.postRealName(crdiSeq, bankCode, bankAccount, realName, birthday)
    }
    override fun postToken() : Boolean{
        return dataSource.postToken()
    }
}