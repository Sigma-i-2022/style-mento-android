package com.sigmai.stylemento.data.model

import com.sigmai.stylemento.global.constant.UserType


object Client {
    private var ClientType : UserType = UserType.NORMAL
    private var nickname : String = "Test1"
    private var email : String = "Test@Email"
    private var introduction : String = ""
    private var closetItems : List<ClosetItem>? = null
    //private var lookbookItems : List<ClosetItem>? = null

    fun setUserName(nickname : String){
        Client.nickname = nickname
    }
    fun setUserEmail(email : String){
        Client.email = email
    }
    fun setUserIntroduction(introduction : String){
        Client.introduction = introduction
    }
    fun setClosetItems(items : List<ClosetItem>?){
        closetItems = items
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
    fun getClosetItems() : List<ClosetItem>?{
        return closetItems
    }
}