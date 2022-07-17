package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.response.member.Member

interface MemberRepository {
    fun getMemberByEmail(email : String): Member
}