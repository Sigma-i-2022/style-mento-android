package com.sigmai.stylemento.data.model


object TestUser {
    private var nickname : String ?= "Test1"
    private var email : String ?= "Test@Email"
    private var introduction : String ?= null

    fun setUserName(nickname : String){
        TestUser.nickname = nickname
    }
    fun setUserEmail(email : String){
        TestUser.email = email
    }
    fun setUserIntroduction(introduction : String){
        TestUser.introduction = introduction
    }
    fun getUserName() : String?{
        return nickname
    }
    fun getUserEmail() : String?{
        return email
    }
    fun getUserIntroduction() : String?{
        return introduction
    }
}