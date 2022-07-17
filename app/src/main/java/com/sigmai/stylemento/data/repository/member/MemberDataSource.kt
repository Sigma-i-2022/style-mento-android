package com.sigmai.stylemento.data.repository.member

import com.sigmai.stylemento.data.api.MemberService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.member.Member
import javax.inject.Inject

class MemberDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<MemberService>()

    fun getMemberByEmail(email : String): Member {
        return service.getMemberByEmail(email).execute().body()!!.data
    }
}