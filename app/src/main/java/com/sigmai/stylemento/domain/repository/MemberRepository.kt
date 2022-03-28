package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.response.member.Member

interface MemberRepository {
    fun postMember(userId : String, email : String, password : String, signupType : String) : Member
    fun getMembers(): List<Member>
    fun upgradeCoordinator(email : String) : Boolean
    fun getMemberByEmail(email : String): Member
}