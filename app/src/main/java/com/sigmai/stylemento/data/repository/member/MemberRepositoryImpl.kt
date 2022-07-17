package com.sigmai.stylemento.data.repository.member

import com.sigmai.stylemento.data.model.response.member.Member
import com.sigmai.stylemento.domain.repository.MemberRepository
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(private val dataSource: MemberDataSource) : MemberRepository {
    override fun getMemberByEmail(email : String): Member {
        return dataSource.getMemberByEmail(email)
    }
}