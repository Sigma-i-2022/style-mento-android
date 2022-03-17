package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.Member
import retrofit2.Call
import retrofit2.http.GET

interface MemberService {
    @GET("v1/api/member")
    fun postMember(

    ): Call<Unit>

    @GET("v1/api/member/all")
    fun getMembers(): Call<ResponseWrapper<List<Member>>>

    @GET("v1/api/member/crdi")
    fun upgradeCoordinator(): Call<Unit>

    @GET("v1/api/member/email")
    fun getMemberByEmail(): Call<Unit>
}