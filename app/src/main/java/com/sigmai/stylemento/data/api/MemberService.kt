package com.sigmai.stylemento.data.api

import com.sigmai.stylemento.data.model.ResponseWrapper
import com.sigmai.stylemento.data.model.response.member.Member
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MemberService {
    @POST("v1/api/member")
    fun postMember(
        @Query("userId") userId : String,
        @Query("email") email : String,
        @Query("password") password : String,
        @Query("signupType") signupType : String
    ): Call<ResponseWrapper<Member>>

    @GET("v1/api/member/all")
    fun getMembers(): Call<ResponseWrapper<List<Member>>>

    @GET("v1/api/member/crdi")
    fun upgradeCoordinator(
        @Query("email") email : String
    ): Call<ResponseWrapper<Unit>>

    @GET("v1/api/member/email")
    fun getMemberByEmail(
        @Query("email") email : String
    ) : Call<ResponseWrapper<Member>>
}