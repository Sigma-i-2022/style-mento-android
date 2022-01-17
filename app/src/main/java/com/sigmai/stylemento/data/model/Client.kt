package com.sigmai.stylemento.data.model

import com.sigmai.stylemento.global.constant.UserType


object Client {
    private var ClientType : UserType = UserType.NORMAL
    private var nickname : String = "Test1"
    private var email : String = "Test@Email"
    private var introduction : String = ""

    fun setUserName(nickname : String){
        Client.nickname = nickname
    }
    fun setUserEmail(email : String){
        Client.email = email
    }
    fun setUserIntroduction(introduction : String){
        Client.introduction = introduction
    }
    fun getUserName() : String{
        return nickname
    }
    fun getUserEmail() : String{
        return email
    }
    fun getUserIntroduction() : String{
        return introduction
    }
}