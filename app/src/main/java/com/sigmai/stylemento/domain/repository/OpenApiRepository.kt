package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.AccountInfo

interface OpenApiRepository {
    fun getAccount(crdiSeq : Long) : AccountInfo
    fun postRealName(crdiSeq : Long, bankCode : String, bankAccount : String, realName : String, birthday : String) : Boolean
    fun postToken() : Boolean
}