package com.sigmai.stylemento.data.repository.member

import com.sigmai.stylemento.data.model.response.member.Member
import com.sigmai.stylemento.domain.repository.MemberRepository
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(private val dataSource: MemberDataSource) : MemberRepository {
    override fun postMember(userId : String, email : String, password : String, signupType : String) : Member {
        return dataSource.postMember(userId, email, password, signupType)
    }
    override fun getMembers(): List<Member> {
        return dataSource.getMembers()
    }
    override fun upgradeCoordinator(email : String) : Boolean {
        return dataSource.upgradeCoordinator(email)
    }
    override fun getMemberByEmail(email : String): Member {
        return dataSource.getMemberByEmail(email)
    }
}