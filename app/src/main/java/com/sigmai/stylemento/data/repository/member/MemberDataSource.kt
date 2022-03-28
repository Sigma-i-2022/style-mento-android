package com.sigmai.stylemento.data.repository.member

import com.sigmai.stylemento.data.api.MemberService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.member.Member
import javax.inject.Inject

class MemberDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<MemberService>()

    fun postMember(userId : String, email : String, password : String, signupType : String) : Member {
        return service.postMember(userId, email, password, signupType).execute().body()!!.data
    }

    fun getMembers(): List<Member>{
        return service.getMembers().execute().body()!!.data
    }

    fun upgradeCoordinator(email : String) : Boolean{
        return service.upgradeCoordinator(email).execute().body()?.success ?: false
    }
    fun getMemberByEmail(email : String): Member {
        return service.getMemberByEmail(email).execute().body()!!.data
    }
}