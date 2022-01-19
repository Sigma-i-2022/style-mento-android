package com.sigmai.stylemento.data.model

import com.sigmai.stylemento.global.constant.UserType


object Client {
    private var clientType : UserType = UserType.NORMAL
    private var nickname : String = "Test1"
    private var email : String = "Test@Email"
    private var introduction : String = ""
    private var closetItems : MutableList<ClosetItem> = mutableListOf()
    private var lookbookItems : MutableList<LookbookItem> = mutableListOf()

    fun setClientType(type: UserType){
        clientType = type
    }
    fun setUserName(nickname : String){
        Client.nickname = nickname
    }
    fun setUserEmail(email : String){
        Client.email = email
    }
    fun setUserIntroduction(introduction : String){
        Client.introduction = introduction
    }
    fun setClosetItems(items : MutableList<ClosetItem>){
        closetItems = items
    }
    fun setLookbookItems(items : MutableList<LookbookItem>){
        lookbookItems = items
    }

    fun getClientType() : UserType{
        return clientType
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
    fun getLookbookItems() : List<LookbookItem>?{
        return lookbookItems
    }

    fun addClosetItem(item : ClosetItem){
        closetItems.add(item)
    }
    fun removeClosetItem(position : Int){
        closetItems.removeAt(position)
    }
    fun reviseClosetItem(item : ClosetItem, position : Int){
        closetItems.removeAt(position)
        closetItems.add(position, item)
    }
    fun addLookbookItem(item : LookbookItem){
        lookbookItems.add(item)
    }
    fun removeLookbookItem(position : Int){
        lookbookItems.removeAt(position)
    }
    fun reviseLookbookItem(item : LookbookItem, position : Int){
        lookbookItems.removeAt(position)
        lookbookItems.add(position, item)
    }

}