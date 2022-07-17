package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.member.Member
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MemberService {
    @GET("v1/admin/api/member/email")
    fun getMemberByEmail(
        @Query("email") email : String
    ) : Call<ResponseWrapper<Member>>
}